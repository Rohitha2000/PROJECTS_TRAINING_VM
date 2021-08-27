
 package com.cts.cit.dao;
 
  import java.util.List;
  
  import org.springframework.data.jpa.repository.JpaRepository; import
  org.springframework.data.jpa.repository.Query;
  
  import com.cts.cit.model.IssueDetail;
  
  public interface CustomerRepo extends JpaRepository<IssueDetail,Integer> {
 
  }
 