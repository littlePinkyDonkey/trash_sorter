package com.trash_sorter.service;

import com.trash_sorter.dao.TrashDAO;
import com.trash_sorter.dao.TrashDaoImpl;
import com.trash_sorter.model.Trash;
import com.trash_sorter.util.Builder;
import com.trash_sorter.util.DbHelper;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class TrashServiceIMPL implements TrashService {
    private DbHelper helper = DbHelper.getInstance(Builder.getConfiguration());
    private final TrashDAO dao;

    private static volatile TrashServiceIMPL instance;
    private TrashServiceIMPL(){
        this.dao = new TrashDaoImpl(helper.getFactory());
    }
    public static TrashServiceIMPL getInstance(){
        if (instance == null){
            synchronized (TrashServiceIMPL.class){
                if (instance == null)
                    instance = new TrashServiceIMPL();
            }
        }
        return instance;
    }

    @Override
    public String[] getTrashName(String barcode) throws IOException {
        BufferedReader in = null;
        String[] result = new String[10];
        try {
            String qrcode =barcode;
            if (qrcode != null) {
                String qr =barcode;

                String url = "https://yandex.ru/search/xml?user=dane-witcher&key=03.74930535:5edff3dee147d498741480ffdeed7a6c&query=" + qr + "&lr=2&l10n=ru&sortby=tm.order%3Dascending&filter=strict&&groupby=attr%3D%22%22.mode%3Dflat.groups-on-page%3D10.docs-in-group%3D1";

                URL obj = new URL(url);

                HttpURLConnection con = (HttpURLConnection) obj.openConnection();

                in = new BufferedReader(
                        new InputStreamReader(con.getInputStream(), "UTF-8"));

            }
            String inputLine;
            StringBuffer response1 = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response1.append(inputLine);
            }

            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
                    .parse(new InputSource(new StringReader(response1.toString())));

            for (int i=0; i<result.length; i++) {
                result[i] = ""
                        + doc.getElementsByTagName("title").item(i).getTextContent();
                System.out.println(result[i]);
            }


        } catch (Exception e) {
            System.out.println(e);
        }finally {
            in.close();
        }
        return result;
    }

    @Override
    public List<String> getAllTrashById(long id) {
        return dao.getAllTrashById(id);
    }

    @Override
    public List<Trash> getAllTrash() {
        return dao.getAllTrash();
    }

    @Override
    public boolean deleteTrash(Trash trash) {
        return dao.deleteTrash(trash);
    }

    @Override
    public Trash getTrashById(long id) {
        return dao.getTrashById(id);
    }

    @Override
    public boolean addNewTrash(Trash trashName) {
        return dao.addNewTrash(trashName);
}

    @Override
    public boolean addNewCategory(long trash_id, long cat_id) {
        return dao.addNewCategory(trash_id,cat_id);
    }
}
