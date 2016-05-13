package sys.Eval.page.Model;
/***********************************************************************
 * Module:  BiEmployeeTeam.java
 * Author:  yxc23
 * Purpose: Defines the Class BiEmployeeTeam
 ***********************************************************************/

import java.util.*;

/** 职工小组
 * 
 * @pdOid aa1d4786-15f7-46a4-b5cc-dd136b5fd650 */
public class BiEmployeeTeam {
   /** 小组代码
    * 
    * @pdOid 785eb709-9d78-4660-8273-1d5f04b92a9e */
   private java.lang.String teamId;
   /** 小组名称
    * 
    * @pdOid c8a18a1b-491c-4632-a5cb-8b13d4c548e2 */
   private java.lang.String teamName;
   /** 是否有效
    * 
    * @pdOid f0b5e183-47a5-4e0f-829b-515097ee92eb */
   private boolean isValid;
   
   /** 备注
    * 
    * @pdOid 62571a87-7c93-4107-b25d-d6b6dfcc4e22 */
   public java.lang.String memo;
   
   /** 职工小组对应 */
   /** @pdRoleInfo migr=no name=BiEmployee assc=zgXz coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<BiEmployee> biEmployee;
   
   /** @pdOid 833b1ae6-e626-4f48-9924-aded76063544 */
   public java.lang.String getTeamId() {
      return teamId;
   }
   
   /** @param newTeamId
    * @pdOid 8f90aa17-bac2-4243-ba3f-d0dfe1f701bf */
   public void setTeamId(java.lang.String newTeamId) {
      teamId = newTeamId;
   }
   
   /** @pdOid 4f3ce0de-c0d9-4537-9864-f4ef62bf112f */
   public java.lang.String getTeamName() {
      return teamName;
   }
   
   /** @param newTeamName
    * @pdOid 987eb36b-5a3d-40bb-ab69-80df48e35dec */
   public void setTeamName(java.lang.String newTeamName) {
      teamName = newTeamName;
   }
   
   /** @pdOid 6643998c-e667-4d89-82b5-8d39d36fd505 */
   public boolean getIsValid() {
      return isValid;
   }
   
   /** @param newIsValid
    * @pdOid 50aa8529-9f70-456e-841e-b9cbf41bd913 */
   public void setIsValid(boolean newIsValid) {
      isValid = newIsValid;
   }
   
   /** @pdOid 47aa63bd-7221-41e4-8246-062babca17ff */
   public java.lang.String getMemo() {
      return memo;
   }
   
   /** @param newMemo
    * @pdOid a33197dd-2b46-412e-af7c-4def2f02dc49 */
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
         newBiEmployee.setBiEmployeeTeam(this);      
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
            oldBiEmployee.setBiEmployeeTeam((BiEmployeeTeam)null);
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
            oldBiEmployee.setBiEmployeeTeam((BiEmployeeTeam)null);
         }
      }
   }

}