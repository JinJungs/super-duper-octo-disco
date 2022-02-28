const SERVESSL01M01 = {
    // 페이지 시작 이벤트 바인딩
    init : function () {
        let _this = this;
        $('#btnSave').on('click', function () {
            _this.save();
        });

        $('#inputSearch').on('keydown', function(e){
            if(e.keyCode==13) {
                _this.selectData();
            }
        });

        $('#btnSearch').on('click', function () {
            _this.selectData();
        });

        // 디폴트로 화면에 들어왔을 때 POS TOKYO 로 검색
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
        let inputData = $('#inputSearch').val();
        if(inputData == "")
            inputData = 'POS TOKYO';

        $.ajax({
            type: 'POST',
            url: '/selectByVessel',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify({"vessel":inputData})
        }).done(function(result) {
            // alert('글을 불러왔습니다!: ' +data);
            // location.reload();
            _this.displayDetail(result);
        }).fail(function (error) {
            alert(error);
        });
    }

    // 조회 데이터 테이블에 셋팅
    , displayDetail : function (data) {

        // 초기화
        $('#tableContent').empty();

        // 템플릿 생성
        let dumyTemplate = $('#_dumyTemplate').html();
        let compile = Handlebars.compile(dumyTemplate);

        data.forEach(function (item) {
            let resultHtml = compile(item);
            let vesselTable = $("#tableContent");
            vesselTable.append(resultHtml);
        });
    }

};

SERVESSL01M01.init();

