package com.voidshell;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.identity.Authentication;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.activiti.engine.test.Deployment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@SpringBootTest
class SpiritApplicationTests {
    /**
     * 根据bpmnb部署,第一次部署会创建数据库,bpmn文件报错及時清理緩存
     */
    @Test
    public void deploy(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        processEngine.getRepositoryService()
                .createDeployment()
                .addClasspathResource("./processes/Test.bpmn")
                .deploy();
    }

    /**
     * 根据部署id删除过期流程
     */
    @Test
    public void testDelete(){
        //得到流程引擎
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //第一个参数是部署的流程的ID，第二个true表示是进行级联删除
        processEngine.getRepositoryService()
                .deleteDeployment("601",true);
    }
    /**
     * 根据名称查询流程部署
     */
//    @Test
//    public void testQueryDeploymentByName() {
//        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
//        List<org.activiti.engine.repository.Deployment> deployments = processEngine.getRepositoryService()
//                .createDeploymentQuery()
//                .orderByDeploymenTime()//按照部署时间排序
//                .desc()//按照降序排序
//                .deploymentName("请假流程")
//                .list();
//        for (Deployment deployment : deployments) {
//            System.out.println(deployment.getId());
//        }
//    }
    /**
     * 启动任务
     * 参数是act_re_procdef表的ID
     * act_re_procdef表:工作流表，一个记录代表一个工作流
     * 启动一个任务会在act_ru_task表生产一个记录
     */
    @Test
    public void testStartProcessInstance(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        processEngine.getRuntimeService()
                .startProcessInstanceById("qjsh:3:7504");  //这个是查看数据库中act_re_procdef表
    }

    /**
     * 完成一项任务
     * 参数是act_ru_task的id,没完成一次进入下一个步骤，每个任务只保留一条记录
     * 任务所有步骤完成，就会删除记录
     */
    @Test
    public void testQingjia(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        processEngine.getTaskService()
                .complete("10005"); //查看act_ru_task表
    }

    /**
     * 查询正在进行的任务
     * 参数是act_ru_task的ASSIGNEE_
     */
    @Test
    public void testQueryTask(){
        //下面代码中的小毛，就是我们之前设计那个流程图中添加的班主任内容
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        List<Task> tasks = processEngine.getTaskService()
                .createTaskQuery()
                .taskAssignee("user2")
                .list();
        for (Task task : tasks) {
            System.out.println(task.getName());
        }
    }

    /**
     * 部署任务，增加名字
     */
    @Test
    public void startDeployByName(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        processEngine.getRepositoryService().createDeployment()
                .name("增加加息申请讨论").addClasspathResource("./processes/jx.bpmn").deploy();
    }
    @Test
    public void testStartPI(){
        /**
         * 流程变量
         *   给<userTask id="请假申请" name="请假申请" activiti:assignee="#{student}"></userTask>
         *     的student赋值
         */
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("user", "小明哥");
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        processEngine.getRuntimeService()
                .startProcessInstanceById("jx:2:25011",variables);
    }

    @Test
    public void testFinishTask_Teacher(){
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("king", "me");
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        processEngine.getTaskService()
                .complete("27506", variables); //完成任务的同时设置流程变量
    }

    @Test
    public void testFinishTask() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        processEngine.getTaskService()
                .complete("30003");
    }


    /**
     * 启动一个任务
     */
//    @Test
//    public void startTask(){
//        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
//        RuntimeService runtimeService = processEngine.getRuntimeService();
//        // 在画流程图的时候,给流程图起的名字
//        String processDefinitionKey = "qjsh";
//        // 业务逻辑中的id
//        String businessKey = "13";
//        ProcessInstance instance = runtimeService.startProcessInstanceByKey(processDefinitionKey, businessKey);
//        System.out.println("ID: " + instance.getId());
//
//    }

//
//    @Autowired
//    private TaskService taskService;
//
//    /**
//     * 完成任务
//     */
//    @Test
//    public void completeTask() {
//        // 通过查询可以拿到user2的任务id是7502
//        String taskId = "22503";
//        // 选通过taskId查询任务
//        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
//        // 从任务里拿到流程实例id
//        String processInstanceId = task.getProcessInstanceId();
//        // 批注信息
//        String message = "讨论结束";
//        Authentication.setAuthenticatedUserId("user2");
//        // 给任务添加批注
//        taskService.addComment(taskId, processInstanceId, message);
//        // 处理任务
//        taskService.complete(taskId);
//    }
//
//    /**
//     * 查询任务
//     */
//    @Test
//    public void queryTask() {
//        List<Task> tasks = taskService.createTaskQuery().taskAssignee("user2")
//                // 分页查询
//                // .listPage(firstResult, maxResults)
//                // 排序
//                // .orderByTaskCreateTime().desc()
//                .list();
//        for (Task task : tasks) {
//            List<Comment> comments = taskService.getProcessInstanceComments(task.getProcessInstanceId());
//            System.out.println("任务ID: " + task.getId());
//            for (Comment comment : comments) {
//                System.out.println("批注人: " + comment.getUserId());
//                System.out.println("批注信息: " + comment.getFullMessage());
//                System.out.println("批注时间: " + comment.getTime());
//            }
//            System.out.println("-------------------------------");
//        }
//    }
//
//
//    @Autowired
//    RuntimeService runtimeService;
//
//    /**
//     * 根据任务id获取业务id
//     */
//    @Test
//    public void getBusinessKey() {
//        // user2 处理了任务, 任务转到 user3 任务id也变成了 10003, 可以使用user3来查询任务获取到
//        String taskId = "2505";
//        // 通过任务id来查询任务
//        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
//        // 通过任务里的流程实例id获取当前任务所属的流程实例信息
//        ProcessInstance instance = runtimeService.createProcessInstanceQuery().processInstanceId(task
//                .getProcessInstanceId()).singleResult();
//        // 从流程实例信息中拿到 businessKey
//        String businessKey = instance.getBusinessKey();
//        System.out.println("businessKey: " + businessKey);
//    }
}
