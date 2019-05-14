import React from 'react'
import { Icon } from 'antd'
import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'

const {
	defaultRenderReferenceCell,
	defaultRenderBooleanCell,
	defaultRenderMoneyCell,
	defaultRenderDateTimeCell,
	defaultRenderImageCell,
	defaultRenderDateCell,
	defaultRenderIdentifier,
	defaultRenderTextCell,
} = BaseTool

const renderTextCell=defaultRenderTextCell
const renderIdentifier=defaultRenderIdentifier
const renderDateCell=defaultRenderDateCell
const renderDateTimeCell=defaultRenderDateTimeCell
const renderImageCell=defaultRenderImageCell
const renderMoneyCell=defaultRenderMoneyCell
const renderBooleanCell=defaultRenderBooleanCell
const renderReferenceCell=defaultRenderReferenceCell


const menuData = {menuName:"用户应用程序", menuFor: "userApp",
  		subItems: [
  {name: 'listAccessList', displayName:'访问列表', icon:'list',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'objectAccessList', displayName:'对象访问', icon:'accessible-icon',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}

const fieldLabels = {
  id: 'ID',
  title: '标题',
  secUser: '安全用户',
  appIcon: '应用程序图标',
  fullAccess: '完全访问',
  permission: '许可',
  objectType: '访问对象类型',
  objectId: '对象ID',
  location: '位置',

}

const displayColumns = [
<<<<<<< HEAD
  { title: fieldLabels.ID, debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'userApp'), sorter:true,sortOrder:"ascend" },
  { title: fieldLabels.title, debugtype: 'string', dataIndex: 'title', width: '8',render: (text, record)=>renderTextCell(text,record), sorter:true },
  { title: fieldLabels.secUser, dataIndex: 'secUser', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.appIcon, debugtype: 'string', dataIndex: 'appIcon', width: '13',render: (text, record)=>renderTextCell(text,record), sorter:true },
  { title: fieldLabels.fullAccess, dataIndex: 'fullAccess', render: (text, record) =>renderBooleanCell(text, record), sorter:true },
  { title: fieldLabels.permission, debugtype: 'string', dataIndex: 'permission', width: '8',render: (text, record)=>renderTextCell(text,record), sorter:true },
  { title: fieldLabels.objectType, debugtype: 'string', dataIndex: 'objectType', width: '31',render: (text, record)=>renderTextCell(text,record), sorter:true },
  { title: fieldLabels.objectId, debugtype: 'string', dataIndex: 'objectId', width: '14',render: (text, record)=>renderTextCell(text,record), sorter:true },
  { title: fieldLabels.location, debugtype: 'string', dataIndex: 'location', width: '16',render: (text, record)=>renderTextCell(text,record), sorter:true },
=======
  { title: fieldLabels.ID, debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'userApp') },
  { title: fieldLabels.title, debugtype: 'string', dataIndex: 'title', width: '8',render: (text, record)=>renderTextCell(text,record) },
  { title: fieldLabels.secUser, dataIndex: 'secUser', render: (text, record) => renderReferenceCell(text, record)},
  { title: fieldLabels.appIcon, debugtype: 'string', dataIndex: 'appIcon', width: '13',render: (text, record)=>renderTextCell(text,record) },
  { title: fieldLabels.fullAccess, dataIndex: 'fullAccess', render: (text, record) =>renderBooleanCell(text, record) },
  { title: fieldLabels.permission, debugtype: 'string', dataIndex: 'permission', width: '8',render: (text, record)=>renderTextCell(text,record) },
  { title: fieldLabels.objectType, debugtype: 'string', dataIndex: 'objectType', width: '31',render: (text, record)=>renderTextCell(text,record) },
  { title: fieldLabels.objectId, debugtype: 'string', dataIndex: 'objectId', width: '14',render: (text, record)=>renderTextCell(text,record) },
  { title: fieldLabels.location, debugtype: 'string', dataIndex: 'location', width: '16',render: (text, record)=>renderTextCell(text,record) },
>>>>>>> 4a59d874a8a184fc3702f98aafd0a6c97f7cdd09

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=({userApp,targetComponent})=>{

	
	
	const {UserAppService} = GlobalComponents
	// const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{userApp.id}</Description> 
<Description term="标题">{userApp.title}</Description> 
<Description term="安全用户">{userApp.secUser==null?appLocaleName(userContext,"NotAssigned"):`${userApp.secUser.displayName}(${userApp.secUser.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"安全用户","secUser",UserAppService.requestCandidateSecUser,
	      UserAppService.transferToAnotherSecUser,"anotherSecUserId",userApp.secUser?userApp.secUser.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="应用程序图标">{userApp.appIcon}</Description> 
<Description term="许可">{userApp.permission}</Description> 
<Description term="访问对象类型">{userApp.objectType}</Description> 
<Description term="对象ID">{userApp.objectId}</Description> 
<Description term="位置">{userApp.location}</Description> 
	
        {buildTransferModal(userApp,targetComponent)}
      </DescriptionList>
	)

}
	



const UserAppBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default UserAppBase



