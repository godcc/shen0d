package cc.shen0d.test.Activity;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

/**
 * RepositoryService Զ�ֿ̲����
 * Deployment �������
 * @author sihan
 *
 */
public class ActivityTest {

	public static void main(String[] args) {
		ProcessEngine codeCreate = getCodeCreate();
		// �������������ݿ�
		// ��ȡԶ�ֿ̲���� �����������
		// DeploymentBuilder createDeployment =
		// codeCreate.getRepositoryService().createDeployment();
		// ���bpmn�������������
		// createDeployment.addClasspathResource("activtyBmp/MyProcess.bpmn");
		// �������ݿ���
		// Deployment deploy = createDeployment.deploy();
		// System.out.println(deploy.getId());
		// ��ȡԶ�ɲֿⲢ������ѯ����
		// DeploymentQuery query =
		// codeCreate.getRepositoryService().createDeploymentQuery();
		// ��ѯ���������ļ򵥽��
		// Deployment singleResult = query.deploymentId("1").singleResult();
		RuntimeService runtime = codeCreate.getRuntimeService();
		TaskService taskService = codeCreate.getTaskService();
		ProcessInstance startProcessInstanceByKey = runtime.startProcessInstanceByKey("myProcess");
		Task singleResult = taskService.createTaskQuery().singleResult();
		System.out.println("��һ������:" + singleResult.getName());
		taskService.complete(singleResult.getId());
		Task singleResult2 = taskService.createTaskQuery().singleResult();
		System.out.println("�ڶ�������:" + singleResult2.getName());
		taskService.complete(singleResult2.getId());
		taskService.createTaskQuery().singleResult();
		Task singleResult3 = taskService.createTaskQuery().singleResult();
		System.out.println("����������" + singleResult3);

	}

	// �����ļ��汾

	public static ProcessEngine getCodeCreate() {
		// �������ö���
		ProcessEngineConfiguration createStandaloneInMemProcessEngineConfiguration = ProcessEngineConfiguration
				.createStandaloneInMemProcessEngineConfiguration();
		// �������ݿ������û���
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
