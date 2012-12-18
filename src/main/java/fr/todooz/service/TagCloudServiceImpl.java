package fr.todooz.service;

import javax.inject.Inject;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import fr.todooz.domain.Task;
import fr.todooz.util.TagCloud;

@Service
public class TagCloudServiceImpl implements TagCloudService {

	@Inject
	private TaskService taskService;

	@Override
	public TagCloud buildTagCloud() {
		TagCloud tagCloud = new TagCloud();
		
		for (Task task : taskService.findAll()) {
			tagCloud.add(StringUtils.split(task.getTags(), ","));
		}

		return tagCloud;
	}

}
