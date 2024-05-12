@import static de.tschuehly.easy.spring.auth.group.management.table.GroupTableComponent.*
@import de.tschuehly.easy.spring.auth.group.management.table.GroupTableComponent.GroupTableContext
@param GroupTableContext groupTableContext
<table id="${GROUP_TABLE_ID}">
    <thead>
    <tr>
        <th>
            Group Name
        </th>
        <th>
            Group Members
        </th>
        <th>

        </th>
    </tr>
    </thead>
    <tbody>
    @for(var group: groupTableContext.groupList())
        <tr>
            <td>
                ${group.groupName}
            </td>
            <td>
                @for(var member: group.memberList)
                    <span>${member.username}</span>
                @else
                    <span>no member</span>
                @endfor
            </td>
        </tr>
    @endfor
    </tbody>
</table>