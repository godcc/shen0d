package cc.shen0d.test.Activity;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

/**
 * RepositoryService 远程仓库服务
 * Deployment 部署对象
 * @author sihan
 *
 */
public class ActivityTest {

	public static void main(String[] args) {
		ProcessEngine codeCreate = getCodeCreate();
		// 部署工作流到数据库
		// 获取远程仓库服务 创建部署对象
		// DeploymentBuilder createDeployment =
		// codeCreate.getRepositoryService().createDeployment();
		// 添加bpmn到到建造对象中
		// createDeployment.addClasspathResource("activtyBmp/MyProcess.bpmn");
		// 部署到数据库中
		// Deployment deploy = createDeployment.deploy();
		// System.out.println(deploy.getId());
		// 获取远成仓库并创建查询服务
		// DeploymentQuery query =
		// codeCreate.getRepositoryService().createDeploymentQuery();
		// 查询部署工作流的简单结果
		// Deployment singleResult = query.deploymentId("1").singleResult();
		RuntimeService runtime = codeCreate.getRuntimeService();
		TaskService taskService = codeCreate.getTaskService();
		ProcessInstance startProcessInstanceByKey = runtime.startProcessInstanceByKey("myProcess");
		Task singleResult = taskService.createTaskQuery().singleResult();
		System.out.println("第一个任务:" + singleResult.getName());
		taskService.complete(singleResult.getId());
		Task singleResult2 = taskService.createTaskQuery().singleResult();
		System.out.println("第二个任务:" + singleResult2.getName());
		taskService.complete(singleResult2.getId());
		taskService.createTaskQuery().singleResult();
		Task singleResult3 = taskService.createTaskQuery().singleResult();
		System.out.println("第三个任务" + singleResult3);

	}

	// 配置文件版本

	public static ProcessEngine getCodeCreate() {
		// 创建配置对象
		ProcessEngineConfiguration createStandaloneInMemProcessEngineConfiguration = ProcessEngineConfiguration
				.createStandaloneInMemProcessEngineConfiguration();
		// 设置数据库链接用户名
		createStandaloneInMemProcessEngineConfiguration.setJdbcDriver("com.mysql.jdbc.Driver");
		createStandaloneInMemProcessEngineConfiguration.setJdbcUsername("root");
		createStandaloneInMemProcessEngineConfiguration.setJdbcPassword("root");
		createStandaloneInMemProcessEngineConfiguration
				.setJdbcUrl("jdbc:mysql:///WebSocket?createDatabaseIfNotExist=true");
		createStandaloneInMemProcessEngineConfiguration.setDatabaseSchemaUpdate("true");
		ProcessEngine buildProcessEngine = createStandaloneInMemProcessEngineConfiguration
				.buildProcessEngine();
		return buildProcessEngine;
	}

}
