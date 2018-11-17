$(document).ready(function () {

    var $addCartItemButtons = $('[role=addCartItem]');

    function refreshCartFields(data) {
        $('.cart-quantity').html(data.itemCount);
        $('.cart-total').each(function () {
            $(this).html(data.total);
        });
    }

    $addCartItemButtons.each(function () {
        var productId = $(this).attr('data-id');
        $(this).on('click', function () {
            $.ajax({
                type: "POST",
                url: '',
                contentType: "",
                data: JSON.stringify({productId: productId}),
                dataType: "json",

            }).data(function (data) {
                refreshCartFields.call(this, data);
            })
        })
    })
});