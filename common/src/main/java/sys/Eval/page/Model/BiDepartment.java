/***********************************************************************
 * Module:  BiDepartment.java
 * Author:  yxc23
 * Purpose: Defines the Class BiDepartment
 ***********************************************************************/
package sys.Eval.page.Model;

/** 科室编码库
 * 
 * @pdOid f7e7c2f5-8819-47eb-97c0-9fc9ade685d1 */
public class BiDepartment {
   /** 科室代码
    * 
    * @pdOid 3000f7b4-e84b-4e69-8eb7-c06fea8c72c9 */
   private java.lang.String depId;
   /** 科室名称
    * 
    * @pdOid aa81c0a5-f377-4df9-8d19-754d0b849511 */
   private java.lang.String depName;
   /** 机构名称
    * 
    * @pdOid 700538a4-b21e-424d-87fb-af43fb55ef6d */
   private java.lang.String corpName;
   /** 科室类别名称
    * 
    * @pdOid 91e49825-4b1b-4d7a-b8d8-53ef46bdf7f4 */
   private java.lang.String depClassName;
   /** 是否有效
    * 
    * @pdOid 31cc3e8c-d237-4e90-bf80-fa15910b96c9 */
   private boolean isVaild;
   /** HIs科室代码
    * 
    * @pdOid 86b7e39e-30dc-40e7-863b-e2339e162e5e */
   private java.lang.String hisId;
   /** His科室名称
    * 
    * @pdOid b3375917-7774-485a-be75-07ca48a6f210 */
   private java.lang.String hisName;
   /** 检索码
    * 
    * @pdOid 03b3fe43-fe76-486a-adb1-cee4dc809ae9 */
   private java.lang.String py;
   
   /** 检索码
    * 
    * @pdOid c1affae1-ab64-4110-81f5-33891ca8c7fc */
   public java.lang.String wb;
   
   /** @pdRoleInfo migr=no name=BiEmployee assc=zgKs coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<BiEmployee> biEmployee;
   /** @pdRoleInfo migr=no name=BiCorporation assc=ksJg mult=1..1 side=A */
   public BiCorporation biCorporation;
   /** @pdRoleInfo migr=no name=BiDepartmentClass assc=ksLb mult=1..1 side=A */
   public BiDepartmentClass biDepartmentClass;
   
   /** @pdOid b8b7cd93-daec-4d67-b830-9d9bc554e8be */
   public java.lang.String getDepId() {
      return depId;
   }
   
   /** @param newDepId
    * @pdOid 9c3820fc-79f3-4b46-b5e2-7e904f890290 */
   public void setDepId(java.lang.String newDepId) {
      depId = newDepId;
   }
   
   /** @pdOid 09b84c3e-8f72-4e01-9411-c1bd5f151bb9 */
   public java.lang.String getDepName() {
      return depName;
   }
   
   /** @param newDepName
    * @pdOid e36a53c1-5e6c-4eb5-9f94-1781545fec26 */
   public void setDepName(java.lang.String newDepName) {
      depName = newDepName;
   }
   
   /** @pdOid e923f889-c6e7-4df3-a748-690fb7e6a719 */
   public java.lang.String getCorpName() {
      return corpName;
   }
   
   /** @param newCorpName
    * @pdOid 86012631-4d15-4cde-9eb7-196232e18dbb */
   public void setCorpName(java.lang.String newCorpName) {
      corpName = newCorpName;
   }
   
   /** @pdOid d711bbe3-9fe8-4d4d-bc20-a7bb8ac3f907 */
   public java.lang.String getDepClassName() {
      return depClassName;
   }
   
   /** @param newDepClassName
    * @pdOid 2445badb-c855-4a37-bbff-106dff2fc516 */
   public void setDepClassName(java.lang.String newDepClassName) {
      depClassName = newDepClassName;
   }
   
   /** @pdOid d197a9fd-7fb5-4a03-aaf5-2a7c30a1ec40 */
   public boolean getIsVaild() {
      return isVaild;
   }
   
   /** @param newIsVaild
    * @pdOid c9200620-8779-446f-ae69-ec3c44df57bc */
   public void setIsVaild(boolean newIsVaild) {
      isVaild = newIsVaild;
   }
   
   /** @pdOid 2381fac2-14d5-4492-ac9c-11d88afd19a6 */
   public java.lang.String getHisId() {
      return hisId;
   }
   
   /** @param newHisId
    * @pdOid 3f925a81-3430-4bd0-bd48-b5385040097e */
   public void setHisId(java.lang.String newHisId) {
      hisId = newHisId;
   }
   
   /** @pdOid fd9fb434-60e4-4e91-8709-cd145890e1fb */
   public java.lang.String getHisName() {
      return hisName;
   }
   
   /** @param newHisName
    * @pdOid df3dfb33-c74c-4d46-8a31-b4ebb271d7da */
   public void setHisName(java.lang.String newHisName) {
      hisName = newHisName;
   }
   
   /** @pdOid ef168fd8-d950-4617-b29d-5d246892cb78 */
   public java.lang.String getPy() {
      return py;
   }
   
   /** @param newPy
    * @pdOid dd8b8192-821e-4108-97f3-691aa6130b1e */
   public void setPy(java.lang.String newPy) {
      py = newPy;
   }
   
   /** @pdOid 8ae3820b-686a-4f65-8cff-6ab470689aba */
   public java.lang.String getWb() {
      return wb;
   }
   
   /** @param newWb
    * @pdOid 05a42e01-30eb-43f1-b09b-f2ea12bf9197 */
   public void setWb(java.lang.String newWb) {
      wb = newWb;
   }
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<BiEmployee> getBiEmployee() {
      if (biEmployee == null)
         biEmployee = new java.util.HashSet<BiEmployee>();
      return biEmployee;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorBiEmployee() {
      if (biEmployee == null)
         biEmployee = new java.util.HashSet<BiEmployee>();
      return biEmployee.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newBiEmployee */
   public void setBiEmployee(java.util.Collection<BiEmployee> newBiEmployee) {
      removeAllBiEmployee();
      for (java.util.Iterator iter = newBiEmployee.iterator(); iter.hasNext();)
         addBiEmployee((BiEmployee)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newBiEmployee */
   public void addBiEmployee(BiEmployee newBiEmployee) {
      if (newBiEmployee == null)
         return;
      if (this.biEmployee == null)
         this.biEmployee = new java.util.HashSet<BiEmployee>();
      if (!this.biEmployee.contains(newBiEmployee))
      {
         this.biEmployee.add(newBiEmployee);
         newBiEmployee.setBiDepartment(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldBiEmployee */
   public void removeBiEmployee(BiEmployee oldBiEmployee) {
      if (oldBiEmployee == null)
         return;
      if (this.biEmployee != null)
         if (this.biEmployee.contains(oldBiEmployee))
         {
            this.biEmployee.remove(oldBiEmployee);
            oldBiEmployee.setBiDepartment((BiDepartment)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllBiEmployee() {
      if (biEmployee != null)
      {
         BiEmployee oldBiEmployee;
         for (java.util.Iterator iter = getIteratorBiEmployee(); iter.hasNext();)
         {
            oldBiEmployee = (BiEmployee)iter.next();
            iter.remove();
            oldBiEmployee.setBiDepartment((BiDepartment)null);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public BiCorporation getBiCorporation() {
      return biCorporation;
   }
   
   /** @pdGenerated default parent setter
     * @param newBiCorporation */
   public void setBiCorporation(BiCorporation newBiCorporation) {
      if (this.biCorporation == null || !this.biCorporation.equals(newBiCorporation))
      {
         if (this.biCorporation != null)
         {
            BiCorporation oldBiCorporation = this.biCorporation;
            this.biCorporation = null;
            oldBiCorporation.removeBiDepartment(this);
         }
         if (newBiCorporation != null)
         {
            this.biCorporation = newBiCorporation;
            this.biCorporation.addBiDepartment(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public BiDepartmentClass getBiDepartmentClass() {
      return biDepartmentClass;
   }
   
   /** @pdGenerated default parent setter
     * @param newBiDepartmentClass */
   public void setBiDepartmentClass(BiDepartmentClass newBiDepartmentClass) {
      if (this.biDepartmentClass == null || !this.biDepartmentClass.equals(newBiDepartmentClass))
      {
         if (this.biDepartmentClass != null)
         {
            BiDepartmentClass oldBiDepartmentClass = this.biDepartmentClass;
            this.biDepartmentClass = null;
            oldBiDepartmentClass.removeBiDepartment(this);
         }
         if (newBiDepartmentClass != null)
         {
            this.biDepartmentClass = newBiDepartmentClass;
            this.biDepartmentClass.addBiDepartment(this);
         }
      }
   }

}