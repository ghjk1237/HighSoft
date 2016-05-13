/***********************************************************************
 * Module:  BiEmployeeGrade.java
 * Author:  yxc23
 * Purpose: Defines the Class BiEmployeeGrade
 ***********************************************************************/
package sys.Eval.page.Model;

/** 职工等级
 * 
 * @pdOid fe8b8fc3-a5e5-42fd-8727-fdd2faa2314b */
public class BiEmployeeGrade {
   /** 小组代码
    * 
    * @pdOid 3d65e622-dc5a-488d-b22b-779ea99a1f61 */
   private java.lang.String gradId;
   /** 小组名称
    * 
    * @pdOid b64548a6-ed4a-48c6-8170-6eccf47deef9 */
   private java.lang.String gradName;
   /** 是否有效
    * 
    * @pdOid 18fc3aab-159c-40b3-8c1b-1b616d3e7943 */
   private boolean isValid;
   /** 奖金提成比例
    * 
    * @pdOid 5cfbd422-f8ec-49f5-9a7f-8c2e8992a5aa */
   private double deductPre;
   
   /** 备注
    * 
    * @pdOid 7e25ee77-4a94-4dc1-9d30-8604eb67d598 */
   public java.lang.String memo;
   
   /** @pdRoleInfo migr=no name=BiEmployee assc=zgLb coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<BiEmployee> biEmployee;
   
   /** @pdOid 4ca022d4-b499-4399-b54e-b242417c4268 */
   public java.lang.String getGradId() {
      return gradId;
   }
   
   /** @param newGradId
    * @pdOid b869e05d-033a-4bf7-82ad-13dd99ce63ce */
   public void setGradId(java.lang.String newGradId) {
      gradId = newGradId;
   }
   
   /** @pdOid 16ed09d0-722d-4641-8c6f-7f065efb1ee5 */
   public java.lang.String getGradName() {
      return gradName;
   }
   
   /** @param newGradName
    * @pdOid 09327750-3aa1-495b-b0ff-3b0acc402a10 */
   public void setGradName(java.lang.String newGradName) {
      gradName = newGradName;
   }
   
   /** @pdOid bf875e2c-5789-4fa7-bb78-ea7edb690164 */
   public boolean getIsValid() {
      return isValid;
   }
   
   /** @param newIsValid
    * @pdOid afd73446-b122-4d5e-a3b1-46e273a8ee54 */
   public void setIsValid(boolean newIsValid) {
      isValid = newIsValid;
   }
   
   /** @pdOid 2b8b7c76-6e3e-41b0-b511-75cc45c28e3d */
   public double getDeductPre() {
      return deductPre;
   }
   
   /** @param newDeductPre
    * @pdOid a7e4ecd9-4797-4d53-925e-bcfaaa090534 */
   public void setDeductPre(double newDeductPre) {
      deductPre = newDeductPre;
   }
   
   /** @pdOid 81938540-17a0-4d48-8c32-6336920ce7dc */
   public java.lang.String getMemo() {
      return memo;
   }
   
   /** @param newMemo
    * @pdOid f81c1280-85c6-4f0a-ae84-3c435a8a0962 */
   public void setMemo(java.lang.String newMemo) {
      memo = newMemo;
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
         newBiEmployee.setBiEmployeeGrade(this);      
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
            oldBiEmployee.setBiEmployeeGrade((BiEmployeeGrade)null);
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
            oldBiEmployee.setBiEmployeeGrade((BiEmployeeGrade)null);
         }
      }
   }

}