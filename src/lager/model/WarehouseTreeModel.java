package lager.model;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

/**
 * Das Warehouse Tree-Model, das das DefaultTreeModel des JTrees erweitert
 */
@SuppressWarnings("serial")
public class WarehouseTreeModel extends DefaultTreeModel {

	public WarehouseTreeModel(TreeNode root) {
		super(root);
		this.asksAllowsChildren = false;
	}

	public void addWarehouse(Warehouse warehouse, MutableTreeNode parent) {
		this.insertNodeInto(warehouse.getNode(), parent, parent.getChildCount());
	}

}