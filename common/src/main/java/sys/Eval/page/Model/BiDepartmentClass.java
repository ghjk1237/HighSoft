/***********************************************************************
 * Module:  BiDepartmentClass.java
 * Author:  yxc23
 * Purpose: Defines the Class BiDepartmentClass
 ***********************************************************************/
package sys.Eval.page.Model;
import java.util.*;

/** 科室类别库
 * 
 * @pdOid 5820356a-ca1f-4969-9f31-8f381871a798 */
public class BiDepartmentClass {
   /** 类别代码
    * 
    * @pdOid f75e57f2-d2cb-4e3e-a448-8fd6eac035e3 */
   private java.lang.String classId;
   /** 类名称
    * 
    * @pdOid 44792321-4e21-4cd9-a2c4-4412cc2b97ef */
   private java.lang.String className;
   /** 是否有效
    * 
    * @pdOid cef042de-35f8-4ac6-95a0-a838306ac054 */
   private boolean isValid;
   
   /** 备注
    * 
    * @pdOid f35bb946-35c6-441b-8177-85dac7df1bd9 */
   public java.lang.String memo;
   
   /** @pdRoleInfo migr=no name=BiDepartment assc=ksLb coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<BiDepartment> biDepartment;
   
   /** @pdOid f8116a58-8f91-479f-b5bc-6c60c8d138b3 */
   public java.lang.String getClassId() {
      return classId;
   }
   
   /** @param newClassId
    * @pdOid 756377a3-5ee6-4c5a-962f-c1289b54b5b4 */
   public void setClassId(java.lang.String newClassId) {
      classId = newClassId;
   }
   
   /** @pdOid 7e5c1221-06ce-4d94-b1c5-10d9e96c54de */
   public java.lang.String getClassName() {
      return className;
   }
   
   /** @param newClassName
    * @pdOid 17ee1fa3-9d0f-4702-9a7d-28fe82b72908 */
   public void setClassName(java.lang.String newClassName) {
      className = newClassName;
   }
   
   /** @pdOid b643bb5e-937e-42d8-bb55-d4effb9c67e8 */
   public boolean getIsValid() {
      return isValid;
   }
   
   /** @param newIsValid
    * @pdOid d8b66e73-6c2a-43d7-abaf-945133320c1d */
   public void setIsValid(boolean newIsValid) {
      isValid = newIsValid;
   }
   
   /** @pdOid c0d1923e-d203-44d4-a893-f99fa96e1425 */
   public java.lang.String getMemo() {
      return memo;
   }
   
   /** @param newMemo
    * @pdOid 255f35fb-d867-4567-a69c-17a0aecf2078 */
   public void setMemo(java.lang.String newMemo) {
      memo = newMemo;
   }
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<BiDepartment> getBiDepartment() {
      if (biDepartment == null)
         biDepartment = new java.util.HashSet<BiDepartment>();
      return biDepartment;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorBiDepartment() {
      if (biDepartment == null)
         biDepartment = new java.util.HashSet<BiDepartment>();
      return biDepartment.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newBiDepartment */
   public void setBiDepartment(java.util.Collection<BiDepartment> newBiDepartment) {
      removeAllBiDepartment();
      for (java.util.Iterator iter = newBiDepartment.iterator(); iter.hasNext();)
         addBiDepartment((BiDepartment)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newBiDepartment */
   public void addBiDepartment(BiDepartment newBiDepartment) {
      if (newBiDepartment == null)
         return;
      if (this.biDepartment == null)
         this.biDepartment = new java.util.HashSet<BiDepartment>();
      if (!this.biDepartment.contains(newBiDepartment))
      {
         this.biDepartment.add(newBiDepartment);
         newBiDepartment.setBiDepartmentClass(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldBiDepartment */
   public void removeBiDepartment(BiDepartment oldBiDepartment) {
      if (oldBiDepartment == null)
         return;
      if (this.biDepartment != null)
         if (this.biDepartment.contains(oldBiDepartment))
         {
            this.biDepartment.remove(oldBiDepartment);
            oldBiDepartment.setBiDepartmentClass((BiDepartmentClass)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllBiDepartment() {
      if (biDepartment != null)
      {
         BiDepartment oldBiDepartment;
         for (java.util.Iterator iter = getIteratorBiDepartment(); iter.hasNext();)
         {
            oldBiDepartment = (BiDepartment)iter.next();
            iter.remove();
            oldBiDepartment.setBiDepartmentClass((BiDepartmentClass)null);
         }
      }
   }

}