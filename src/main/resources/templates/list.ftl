<html>
<title>
    test
</title>
<body>
<table>
    <thead>
    <th>序号</th>
    <th>名字</th>
    </thead>
    <tbody>
    <#list persons as person >
    <tr>
        <td>${person.id}</td>
        <td>${person.name}</td>
    </tr>
    </#list>
    </tbody>
</table>
</body>
</html>