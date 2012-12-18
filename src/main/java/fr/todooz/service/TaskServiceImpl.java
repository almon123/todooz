package fr.todooz.service;


import java.util.List;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.todooz.domain.Task;


@Service
public class TaskServiceImpl implements TaskService {

	@Inject
	private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see fr.todooz.service.TaskService#save(fr.todooz.domain.Task)
	 */
	@Override
	@Transactional
	public void save(Task task) {
		
		Session session = sessionFactory.getCurrentSession(); 
		session.save(task);
		
	}

	/* (non-Javadoc)
	 * @see fr.todooz.service.TaskService#delete(java.lang.Long)
	 */
	@Override
	@Transactional
	public void delete(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Task task = (Task) session.get(Task.class, id);		
		session.delete(task);

		
	}

	/* (non-Javadoc)
	 * @see fr.todooz.service.TaskService#findAll()
	 */
	@Override
	@Transactional
	public List<Task> findAll() {
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Task.class);
		List<Task> tasks = crit.list();
		return tasks;
		
	}
	
	@Override
	@Transactional
	public Task findById(Long id){
		Session session = sessionFactory.getCurrentSession();
		
		return (Task)session.get(Task.class, id);
			
	}
	
	

	/* (non-Javadoc)
	 * @see fr.todooz.service.TaskService#findByQuery(java.lang.String)
	 */
	@Override
	@Transactional
	public List<Task> findByQuery(String query) {
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Task.class);
		crit.add(Restrictions.ilike("title", query, MatchMode.ANYWHERE));
		return crit.list();
		
	}

	/* (non-Javadoc)
	 * @see fr.todooz.service.TaskService#count()
	 */
	@Override
	@Transactional
	public int count() {
		List<Task> tasks = this.findAll();
		return tasks.size();
			
	}
}
