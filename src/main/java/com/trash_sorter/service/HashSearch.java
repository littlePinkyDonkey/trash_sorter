package com.trash_sorter.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class HashSearch {
    public static void main(String[] args) {
        search(Arrays.asList(new String[] {"q", "w"}), new String[] {"q", "w"});
    }
    /**@param trash_list - данные из базы
     * @param net_array - массив результатов поиска
     * идея: т.к. hashset использует для проверки наличия hashcode() и equal() (вроде как)
     * то быстрее будет это использовать для нахождения уникальныого мусора
     * @return boolean, но это нужно изменить в соответствии с логикой  общения с бд
     * */



    public static String search(List<String> trash_list, String[] net_array){





        String name = null;
        boolean can_drop = false;
        HashSet<String> words_set = new HashSet<>();

        HashSet<String> trash_set = new HashSet<>(trash_list);
        //trash_list.stream().map(Trash::getName).collect(Collectors.toSet())

        //из массива строк получаем коллекцию слов
        for (int i = 0; i < net_array.length; i++){
            try{
                String[] inner_array = net_array[i] .toLowerCase().split(" ");
                words_set.addAll(new HashSet<>(Arrays.asList(inner_array)));
            }catch (NullPointerException e){
                continue;
            }
        }

        //проходимся по всем словам и проверям есть ли этот мусор в базе(trash_list)
        for (String word : words_set){
            for (String trash : trash_set) {
                if (word.contains(trash)) {
                    can_drop = true;
                    name = word;
                }
            }
        }
        StringBuilder queryBuilder = new StringBuilder(
                "SELECT * FROM tanks t WHERE t.id IN (\n" +
                        "    SELECT tac.tank_id FROM tanks_and_cats tac WHERE tac.category_id IN (\n" +
                        "        SELECT category_id FROM trash WHERE id IN (\n" +
                        "            SELECT id FROM trash WHERE name LIKE "
        );
        int im = 0;
        for (String word : words_set){
            queryBuilder.append("'%" + word + "%'");
            if (im != words_set.size() - 1) {
                queryBuilder.append(" OR name LIKE ");
            }
            im++;
        }
        queryBuilder.append(")\n" +
                "        )\n" +
                "    )");
        System.out.println(queryBuilder.toString());
        if (name == null) {
            System.out.println("Нам нужно выкинуть в другой мусорник ");
        }

        return name;
    }
}
