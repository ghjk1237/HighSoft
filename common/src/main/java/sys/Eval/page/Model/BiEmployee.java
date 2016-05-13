package sys.Eval.page.Model;
/***********************************************************************
 * Module:  BiEmployee.java
 * Author:  yxc23
 * Purpose: Defines the Class BiEmployee
 ***********************************************************************/

import java.util.*;

/** 职工编码
 * 
 * @pdOid 60bea887-5728-4002-a8b6-8dee90ff629e */
public class BiEmployee {
   /** 工号
    * 
    * @pdOid 616a1b23-81da-4644-89c4-e9aae2d25143 */
   private java.lang.String empId;
   /** 姓名
    * 
    * @pdOid ddddbf9a-78c5-4c9b-a478-1ea4927dfc8c */
   private java.lang.String empName;
   /** 性别 枚举 female male unknown
    * 
    * @pdOid 726d8ae7-d6b5-4bf6-97bc-1c6a085430ae */
   private java.lang.String gender;
   /** 邮箱
    * 
    * @pdOid 49441762-05e0-465b-b1a3-9e8ce8b1e71d */
   private java.lang.String email;
   /** 身份号
    * 
    * @pdOid d1b0e065-052c-42c7-b3ec-1c44f2b2d8fd */
   private java.lang.String idCard;
   /** 生日
    * 
    * @pdOid 40a38c63-8a5a-4068-8698-22d4e2a203ee */
   private java.util.Date birth;
   /** 电话
    * 
    * @pdOid 82a4557c-5c6c-4554-b39f-e6ba0627dd3d */
   private java.lang.String phone;
   /** 联系地址
    * 
    * @pdOid 2cf01264-8c49-4c67-8bcf-b42fb391a7e9 */
   private java.lang.String address;
   /** 科室名称
    * 
    * @pdOid e7612e7e-adcb-4bf4-857b-3118f3f6813b */
   private java.lang.String depName;
   /** 小组名称
    * 
    * @pdOid edb0ec59-7d27-4b12-b1d1-a50c870636bc */
   private java.lang.String teamName;
   /** 是否有效 0 无效 1有效
    * 
    * @pdOid 3bf064ca-d705-475a-94be-ecbb39f0625c */
   private boolean isValid;
   /** 是否允许登陆0 不允许 1允许
    * 
    * @pdOid cfade66a-d5aa-4a3f-9458-ab78aeddfcf1 */
   private boolean loginable;
   /** 检索码
    * 
    * @pdOid e9e11831-3019-4f37-b5e9-1ddff0ca6cea */
   private java.lang.String py;
   /** 检索码
    * 
    * @pdOid e7e56e7d-8dc7-4507-8fd3-6e4ab8fd4045 */
   private java.lang.String wb;
   /** 入职日期
    * 
    * @pdOid ee11bca1-54da-4ce1-abd0-96620940f1c1 */
   private java.util.Date hireDate;
   /** His职工编号
    * 
    * @pdOid 5204affc-fcf7-4d8a-84e7-1f9892340585 */
   private java.lang.String hisId;
   /** His名称
    * 
    * @pdOid 9ef9910d-8965-420d-acbb-16b6d46de83c */
   private java.lang.String hisName;
   
   /** @pdRoleInfo migr=no name=BiDepartment assc=zgKs mult=1..1 side=A */
   public BiDepartment biDepartment;
   /** 职工小组对应 */
   /** @pdRoleInfo migr=no name=BiEmployeeTeam assc=zgXz mult=0..1 side=A */
   public BiEmployeeTeam biEmployeeTeam;
   /** @pdRoleInfo migr=no name=BiEmployeeGrade assc=zgLb mult=1..1 side=A */
   public BiEmployeeGrade biEmployeeGrade;
   
   /** @pdOid 1c400b5a-3852-48f4-bb5c-b45a3b15e4d2 */
   public java.lang.String getEmpId() {
      return empId;
   }
   
   /** @param newEmpId
    * @pdOid 44eaf46f-4a59-4abb-b5d2-4a827183af6c */
   public void setEmpId(java.lang.String newEmpId) {
      empId = newEmpId;
   }
   
   /** @pdOid 61aeae44-a9ec-46fd-80ba-798d9295002d */
   public java.lang.String getEmpName() {
      return empName;
   }
   
   /** @param newEmpName
    * @pdOid ac85d4fd-ce22-47f1-9479-e2bcc56e1dd9 */
   public void setEmpName(java.lang.String newEmpName) {
      empName = newEmpName;
   }
   
   /** @pdOid f33cc458-9f3b-4318-b48f-73796bffc1aa */
   public java.lang.String getGender() {
      return gender;
   }
   
   /** @param newGender
    * @pdOid c7ab5409-426c-41af-ae86-b6d0b4d223df */
   public void setGender(java.lang.String newGender) {
      gender = newGender;
   }
   
   /** @pdOid c66c4232-d8d1-47ae-a1b1-f8f03724b41c */
   public java.lang.String getEmail() {
      return email;
   }
   
   /** @param newEmail
    * @pdOid 5904d39e-03c6-4e31-91d9-65a7bb143359 */
   public void setEmail(java.lang.String newEmail) {
      email = newEmail;
   }
   
   /** @pdOid df1dde02-ac75-4994-980b-d80b7d8404a3 */
   public java.lang.String getIdCard() {
      return idCard;
   }
   
   /** @param newIdCard
    * @pdOid 226235d0-22ee-40e4-95e2-c0992ed7c02f */
   public void setIdCard(java.lang.String newIdCard) {
      idCard = newIdCard;
   }
   
   /** @pdOid caee9860-a7a7-4254-9d9c-13f86d6f4389 */
   public java.util.Date getBirth() {
      return birth;
   }
   
   /** @param newBirth
    * @pdOid c47136f4-e313-4323-a8c6-647551893a02 */
   public void setBirth(java.util.Date newBirth) {
      birth = newBirth;
   }
   
   /** @pdOid 59274a66-6221-4a7a-bfdb-0da190d7bbaa */
   public java.lang.String getPhone() {
      return phone;
   }
   
   /** @param newPhone
    * @pdOid 05ce8090-588f-4e39-9ca6-1ae32819b1a1 */
   public void setPhone(java.lang.String newPhone) {
      phone = newPhone;
   }
   
   /** @pdOid 0f13a6c9-4575-45d6-ab98-cbf9b315df2f */
   public java.lang.String getAddress() {
      return address;
   }
   
   /** @param newAddress
    * @pdOid ecc13fd8-ffbb-4115-92f4-b56023f937a5 */
   public void setAddress(java.lang.String newAddress) {
      address = newAddress;
   }
   
   /** @pdOid cdcebc47-1c36-4552-b3fe-ae27f16d031f */
   public java.lang.String getDepName() {
      return depName;
   }
   
   /** @param newDepName
    * @pdOid d531183b-b427-4a3b-b417-60e94658c80b */
   public void setDepName(java.lang.String newDepName) {
      depName = newDepName;
   }
   
   /** @pdOid 9d7812d0-f509-4922-83f1-f1df6f1a187b */
   public java.lang.String getTeamName() {
      return teamName;
   }
   
   /** @param newTeamName
    * @pdOid fd689a30-2b74-4236-952e-df90126662fa */
   public void setTeamName(java.lang.String newTeamName) {
      teamName = newTeamName;
   }
   
   /** @pdOid 742d536a-0c1d-4fcf-a329-b35af8b1ca90 */
   public boolean getIsValid() {
      return isValid;
   }
   
   /** @param newIsValid
    * @pdOid 4bff7285-864c-47cf-a281-f943c296fa79 */
   public void setIsValid(boolean newIsValid) {
      isValid = newIsValid;
   }
   
   /** @pdOid 6cd95a8f-4d32-4043-bae1-c828f1b28f0d */
   public boolean getLoginable() {
      return loginable;
   }
   
   /** @param newLoginable
    * @pdOid 9cb61fc8-6f5e-4c44-b46c-355b0f9ddc5b */
   public void setLoginable(boolean newLoginable) {
      loginable = newLoginable;
   }
   
   /** @pdOid af1bfdfb-df9c-4c2f-aa71-0afca5710032 */
   public java.lang.String getPy() {
      return py;
   }
   
   /** @param newPy
    * @pdOid 0ca34a1f-a9c7-4efa-a797-ce81b779b474 */
   public void setPy(java.lang.String newPy) {
      py = newPy;
   }
   
   /** @pdOid f645f7cf-4fde-478d-bd6f-1e6714a2fef7 */
   public java.lang.String getWb() {
      return wb;
   }
   
   /** @param newWb
    * @pdOid 8e2156f7-6386-4370-85be-ddcca9b524b6 */
   public void setWb(java.lang.String newWb) {
      wb = newWb;
   }
   
   /** @pdOid 64491f9d-a50f-45d8-b9ef-e01d1055e0f7 */
   public java.util.Date getHireDate() {
      return hireDate;
   }
   
   /** @param newHireDate
    * @pdOid 07c7e6f7-218c-44ae-9433-cca962d2bfa7 */
   public void setHireDate(java.util.Date newHireDate) {
      hireDate = newHireDate;
   }
   
   /** @pdOid 12b8d45b-38f0-4bb1-883f-c9592d4ade84 */
   public java.lang.String getHisId() {
      return hisId;
   }
   
   /** @param newHisId
    * @pdOid b3ca2b38-83e1-4570-a237-570079194883 */
   public void setHisId(java.lang.String newHisId) {
      hisId = newHisId;
   }
   
   /** @pdOid 2eedf3cf-9d0e-45d0-a033-e043ca42a717 */
   public java.lang.String getHisName() {
      return hisName;
   }
   
   /** @param newHisName
    * @pdOid f7bd5a41-4f32-4427-826a-6c4f6cfe176b */
   public void setHisName(java.lang.String newHisName) {
      hisName = newHisName;
   }
   
   
   /** @pdGenerated default parent getter */
   public BiDepartment getBiDepartment() {
      return biDepartment;
   }
   
   /** @pdGenerated default parent setter
     * @param newBiDepartment */
   public void setBiDepartment(BiDepartment newBiDepartment) {
      if (this.biDepartment == null || !this.biDepartment.equals(newBiDepartment))
      {
         if (this.biDepartment != null)
         {
            BiDepartment oldBiDepartment = this.biDepartment;
            this.biDepartment = null;
            oldBiDepartment.removeBiEmployee(this);
         }
         if (newBiDepartment != null)
         {
            this.biDepartment = newBiDepartment;
            this.biDepartment.addBiEmployee(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public BiEmployeeTeam getBiEmployeeTeam() {
      return biEmployeeTeam;
   }
   
   /** @pdGenerated default parent setter
     * @param newBiEmployeeTeam */
   public void setBiEmployeeTeam(BiEmployeeTeam newBiEmployeeTeam) {
      if (this.biEmployeeTeam == null || !this.biEmployeeTeam.equals(newBiEmployeeTeam))
      {
         if (this.biEmployeeTeam != null)
         {
            BiEmployeeTeam oldBiEmployeeTeam = this.biEmployeeTeam;
            this.biEmployeeTeam = null;
            oldBiEmployeeTeam.removeBiEmployee(this);
         }
         if (newBiEmployeeTeam != null)
         {
            this.biEmployeeTeam = newBiEmployeeTeam;
            this.biEmployeeTeam.addBiEmployee(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public BiEmployeeGrade getBiEmployeeGrade() {
      return biEmployeeGrade;
   }
   
   /** @pdGenerated default parent setter
     * @param newBiEmployeeGrade */
   public void setBiEmployeeGrade(BiEmployeeGrade newBiEmployeeGrade) {
      if (this.biEmployeeGrade == null || !this.biEmployeeGrade.equals(newBiEmployeeGrade))
      {
         if (this.biEmployeeGrade != null)
         {
            BiEmployeeGrade oldBiEmployeeGrade = this.biEmployeeGrade;
            this.biEmployeeGrade = null;
            oldBiEmployeeGrade.removeBiEmployee(this);
         }
         if (newBiEmployeeGrade != null)
         {
            this.biEmployeeGrade = newBiEmployeeGrade;
            this.biEmployeeGrade.addBiEmployee(this);
         }
      }
   }

}