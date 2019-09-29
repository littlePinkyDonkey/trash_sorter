

$(document).ready(function () {
    $('#inputGroupFile01').on('click', function () {
        var barcode = getDecodedCode();
    });

    $('#inputGroupFile01').on('change', function () {
        $('#answerModal').modal('show');
    });

    $('#answerModal').on('hidden.bs.modal', function () {
        resetModalContent();
    })
});

function getTrashAnswer(tankId, barCode) {
    let result = null;

    $.ajax({
        method: 'post',
        url: '/worker',
        data: {
            'tankId': tankId,
            'barCode': barCode
        },
        async: false,
        success:  function(t) {
            result = t;
            if(result.isvalidate) {
                showSuccessContent(result);
            } else {
                showDeniedContent(result);
            }
        },
        error: function (e) {
            console.log(e);
        }
    });

    return result;
}

function getTankId() {
    var url_string = window.location.href;
    var url = new URL(url_string);
    return url.searchParams.get("id");
}

function showSuccessContent(trash) {
    let contentBlock = $('#a1');
    contentBlock.empty();

    let content = `<p><strong>Наименование продукта: </strong><div id="name">${trash.name}</div></p><p><strong>Штрихкод: </strong><div id="barcode">${trash.barcode}</div></p><p>
                    <strong>Это тот товар:</strong></p><p><button type="button"  Style="width:100%" class="btn btn-success" 
                    onclick="$('#a1').empty().prepend('<h4><strong>ВЫ МОЖЕТЕ ВЫКИДЫВАТЬ МУСОР\\'</h4></strong>').prepend($('<img>',{id:'#a1',src:'img/yes.png'}));" 
                    data-dismiss="modal">Да</button></p><p><button type="button"  Style="width:100%" class="btn btn-danger" 
                    onclick="$('#a1').empty().prepend('<h4><strong>ВЫ НЕ МОЖЕТЕ ВЫКИДЫВАТЬ МУСОР\\'</h4></strong>').prepend($('<img>',{id:'#a1',src:'img/no.png'}));" 
                    data-dismiss="modal" >Нет</button></p>`;

    contentBlock.append(content);

}

function showDeniedContent(trash) {
    let contentBlock = $('#a1');
    contentBlock.empty();

    let content = `<p><strong>Наименование продукта: </strong><div id="name">${trash.name}</div></p><p><strong>Штрихкод: </strong><div id="barcode">${trash.barcode}</div></p><p>
                    <strong>Это тот товар:</strong></p><p><button type="button"  Style="width:100%" class="btn btn-success" 
                    onclick="$('#a1').empty().prepend('<h4><strong>ВЫ НЕ МОЖЕТЕ ВЫКИДЫВАТЬ МУСОР\\'</h4></strong>').prepend($('<img>',{id:'#a1',src:'img/no.png'}));" 
                    data-dismiss="modal">Да</button></p><p><button type="button"  Style="width:100%" class="btn btn-danger" 
                    onclick="$('#a1').empty().prepend('<h4><strong>ВЫ НЕ МОЖЕТЕ ВЫКИДЫВАТЬ МУСОР\\'</h4></strong>').prepend($('<img>',{id:'#a1',src:'img/no.png'}));" 
                    data-dismiss="modal" >Нет</button></p>`;

    contentBlock.append(content);
}

function resetModalContent() {
    $('#a1').empty();
    $('#a1').append(
        `<img src="img/loading.gif" align="center" width="290px"/>`
    );
}

function getDecodedCode(){
    let reader;
    let result = '';
    document.getElementById('inputGroupFile01').addEventListener('change', async function(){
        if(!reader){
            reader = await Dynamsoft.BarcodeReader.createInstance();
        }
        reader.decode(this.files[0]).then(results => {
            if (results.length > 0) {
                console.log(results);
                var txts = [];
                for (var i = 0; i < results.length; ++i) {
                    txts.push(results[i].BarcodeText);
                }
                //var barCode = txts.join("\n");
                getTrashAnswer(getTankId(), txts.join("\n"));
                //console.log(getTrashAnswer(txts.join("\n")));

                this.value = '';
            }
        });
    });
}

                    