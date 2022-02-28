const SERVESSL01M01 = {
    // 페이지 시작 이벤트 바인딩
    init : function () {
        let _this = this;
        $('#btnSave').on('click', function () {
            _this.save();
        });
        _this.selectData();
    }

    // 데이터 저장
    , save : function () {
        let data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/posts',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 등록되었습니다.');
            location.reload();
        }).fail(function (error) {
            alert(error);
        });
    }

    // 데이터 조회
    , selectData : function () {
        let _this = this;

        $.ajax({
            type: 'POST',
            url: '/selectByVessel',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
        }).done(function(data) {
            // alert('글을 불러왔습니다!: ' +data);
            // location.reload();
            _this.displayDetail(data);
        }).fail(function (error) {
            alert(error);
        });
    }

    // 조회 데이터 테이블에 셋팅
    , displayDetail : function (data) {

        let dumyTemplate = document.querySelector('#_dumyTemplate').innerHTML;
        let compile = Handlebars.compile(dumyTemplate);

        data.forEach(function (item) {
            let resultHtml = compile(item);
            let vesselTable = document.querySelector("#tableContent");
            vesselTable.innerHTML += resultHtml;
        });
    }

};

SERVESSL01M01.init();

