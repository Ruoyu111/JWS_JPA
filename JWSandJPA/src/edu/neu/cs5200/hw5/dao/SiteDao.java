package edu.neu.cs5200.hw5.dao;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.neu.cs5200.hw5.models.Site;
import edu.neu.cs5200.hw5.models.Tower;

@Path("/site")
public class SiteDao {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("JWSandJPA");
	EntityManager em = factory.createEntityManager();
	
	// crud
	// findSite
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Site findSite(@PathParam("id") int siteId)
	{
		return em.find(Site.class, siteId);
	}
	
	// findAllSites
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@SuppressWarnings("unchecked")
	public List<Site> findAllSites()
	{
		Query query = em.createQuery("select site from Site site");
		return (List<Site>)query.getResultList();
	}
	
	// updateSite
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Site> updateSite(@PathParam("id") int siteId, Site site)
	{
		
		
		em.getTransaction().begin();
		site.setId(siteId);
		em.merge(site);
		em.getTransaction().commit();
		return findAllSites();
	}
	
	// removeSite
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Site> removeSite(@PathParam("id") int siteId)
	{
		em.getTransaction().begin();
		Site site = findSite(siteId);
		em.remove(site);
		em.getTransaction().commit();
		return findAllSites();
	}
	
	// createSite
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Site> createSite(Site site) {
		em.getTransaction().begin();
		em.persist(site);
		em.getTransaction().commit();
		return findAllSites();
	}
	
	public static void main(String[] args)
	{
		SiteDao dao = new SiteDao();
		
//		 findSite test
//		Site site = dao.findSite(1);
//		System.out.println(site.getName());
		
		// findAllSites test
//		List<Site> sites = dao.findAllSites();
//		for(Site site : sites)
//		{
//			System.out.println(site.getName());
//		}
//		
		// updateSite test
//		Site bc = dao.findSite(5);
//		bc.setName("bcSite");
//		List<Site> sites = dao.updateSite(5, bc);
//		for(Site site : sites)
//		{
//			System.out.println(site.getName());
//		}
		
		// removeSite test
//		List<Site> sites = dao.removeSite(4);
//		for(Site site : sites)
//		{
//			System.out.println(site.getName());
//		}
		
		// createSite test
//		Site site = new Site(null, "bcSite", "bcLatitude", "bcLongitude");
//		List<Site> sites = dao.createSite(site);
//		for(Site s : sites)
//			{
//				System.out.println(s.getName());
//			}
		
		// retrieve towers in Site neu
//		Site neu = dao.findSite(1);
//		System.out.println(neu.getTowers().size());
//		List<Tower> towers = neu.getTowers();
//		for(Tower tower : towers)
//		{
//			System.out.println((tower.getName()));
//		}
	}


}
