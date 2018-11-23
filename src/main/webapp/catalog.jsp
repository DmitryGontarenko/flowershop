 <%@ page contentType="text/html;charset=UTF-8" language="java" %>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="w" tagdir="/WEB-INF/tags" %>

 <w:wrapper>
     <form method="get" action="/catalog" style="margin-left: 0 !important;">
         <input type="text" name="productName" id="productName" placeholder="Поиск">
         <button type="submit">Поиск</button>
     </form>

     <%--ВЫВОД СПИСКА ТОВАРОВ--%>
     <div class="CartGoods">
         <c:forEach var="product" items="${productlist}">
             <table  class="tstyle">
                 <tr><h3>${product.name}</h3></tr>
                 <tr>
                     <td>Цена: ${product.price}</td>
                     <td>В наличии: ${product.inStock}</td>
                 </tr>
             </table>
             <button class="add-to-cart" role="addCartItem" data-id="${product.id}">Добавить в корзину</button>
         </c:forEach>
     </div>
 </w:wrapper>
