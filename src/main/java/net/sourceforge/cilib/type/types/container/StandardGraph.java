/*
 * StandardGraph.java
 * 
 * Copyright (C) 2004 - CIRG@UP 
 * Computational Intelligence Research Group (CIRG@UP)
 * Department of Computer Science 
 * University of Pretoria
 * South Africa
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package net.sourceforge.cilib.type.types.container;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import net.sourceforge.cilib.container.visitor.Visitor;
import net.sourceforge.cilib.type.types.AbstractType;

public class StandardGraph<E extends Comparable<E>> extends AbstractType implements Graph<E> {
	
	private static final long serialVersionUID = -5517089079342858152L;
	private Map<E, List<E>> adjacencyMap;
	
	public StandardGraph() {
		adjacencyMap = new LinkedHashMap<E, List<E>>();
	}
	
	public StandardGraph<E> clone() {
		return null;
	}

	public int edges() {
		int count = 0;
		
		Collection<List<E>> edgeLists = this.adjacencyMap.values();
		for (List<E> list : edgeLists) {
			count += list.size();
		}
		
		return count;
	}

	public int vertices() {
		return this.adjacencyMap.size();
	}
	
	public boolean addEdge(E a, E b) {
		if (!contains(a)) return false;
		if (!contains(b)) return false;
		
		List<E> connectedVerticies = this.adjacencyMap.get(a);
		connectedVerticies.add(b);
		
		return true;
	}

	public boolean isConnected(E a, E b) {
		if (!contains(a)) return false;
		if (!contains(b)) return false;
		
		List<E> connectedVerticies = this.adjacencyMap.get(a);
		return connectedVerticies.contains(b);
	}

	public void accept(Visitor<E> visitor) {
		throw new UnsupportedOperationException("accept() for the class " + getClass().getName() + " still needs an implementation");		
	}

	public boolean add(E element) {
		if (this.adjacencyMap.containsKey(element))
			return false;
		
		this.adjacencyMap.put(element, new LinkedList<E>());
		return true;
	}

	public void clear() {
		this.adjacencyMap.clear();
	}

	public boolean contains(E element) {
		return this.adjacencyMap.containsKey(element);
	}

	public boolean isEmpty() {
		return this.adjacencyMap.isEmpty();
	}

	public Iterator<E> iterator() {
		return this.adjacencyMap.keySet().iterator();
	}

	public boolean remove(E element) {
		if (!this.adjacencyMap.containsKey(element))
			return false;
		
		this.adjacencyMap.remove(element);
		
		Collection<List<E>> lists = this.adjacencyMap.values();
		
		for (List<E> list : lists) {
			if (list.contains(element))
				list.remove(element);
		}
		
		return true;
	}
	
	public E remove(int index) {
		int count = 0;
		for (Map.Entry<E, List<E>> e : this.adjacencyMap.entrySet()) {
			if (count == index) {
				this.adjacencyMap.remove(e.getKey());
				return e.getKey();
			}
			
			count++;				
		}
		
		return null;
	}

	public int size() {
		return this.adjacencyMap.size();
	}

	public int getDimension() {
		return this.vertices();
	}

	public String getRepresentation() {
		throw new UnsupportedOperationException("getRepresentation() is not supportd");
	}

	public void randomise() {
		throw new UnsupportedOperationException("randomise() is not supportd");		
	}

	public void reset() {
		throw new UnsupportedOperationException("reset() is not supportd");	
	}

	public boolean addAll(Structure<E> structure) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean removeAll(Structure<E> structure) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isInsideBounds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
