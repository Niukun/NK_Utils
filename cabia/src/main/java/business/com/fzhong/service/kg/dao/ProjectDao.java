package business.com.fzhong.service.kg.dao;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.Values;

import base.com.fzhong.service.db.neo4j.impl.BaseNeo4jImpl;
import business.com.fzhong.service.kg.dto.ProjectDto;
import business.com.fzhong.service.kg.utils.FZhongConsts;

public class ProjectDao {

	private static Driver driver = BaseNeo4jImpl.getDriver();
	
	/**
	 * 通过项目id查询项目信息
	 */
	public List<ProjectDto> getProjectInfoByProjectId(String id) {
		Session session = driver.session();
		String str = FZhongConsts.GETPROJECTINFOBYPROJECTID;
		StatementResult result = session.run(str, Values.parameters("id", id));
		List<ProjectDto> list = new ArrayList<ProjectDto>();
		ProjectDto project = new ProjectDto();
		while (result.hasNext()) {
			Record record = result.next();
			project.setProjectID(record.get("projectId").asString());
			project.setProjectName(record.get("projectName").asString());
			project.setUpdateTime(record.get("updateTime").asString());
			list.add(project);
		}

		session.close();
		return list;
	}
	
	/**
	 * 通过楼宇id查询项目信息
	 */
	public List<ProjectDto> getProjectListByBuilding(String id) {
		Session session = driver.session();
		String str = FZhongConsts.GETPROJECTLISTBYBUILDING;
		StatementResult result = session.run(str, Values.parameters("id", id));
		List<ProjectDto> list = new ArrayList<ProjectDto>();
		ProjectDto project = new ProjectDto();
		while (result.hasNext()) {
			Record record = result.next();
			project.setProjectID(record.get("projectId").asString());
			project.setProjectName(record.get("projectName").asString());
			project.setUpdateTime(record.get("updateTime").asString());
			list.add(project);
		}
		session.close();
		return list;
	}
	
	/**
	 * 通过楼宇查询项目
	 */
	public List<ProjectDto> getProjectListByBuildingId(String id) {
		Session session = driver.session();
		String str = FZhongConsts.GETPROJECTLISTBYBUILDINGID;
		StatementResult result = session.run(str, Values.parameters("id", id));
		List<ProjectDto> list = new ArrayList<ProjectDto>();
		ProjectDto project = new ProjectDto();
		while (result.hasNext()) {
			Record record = result.next();
			project.setProjectID(record.get("projectId").asString());
			project.setProjectName(record.get("projectName").asString());
			project.setUpdateTime(record.get("updateTime").asString());
			list.add(project);
		}
		session.close();
		return list;

	}
}
