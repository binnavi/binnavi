/*
Copyright 2011-2016 Google Inc. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package com.google.security.zynamics.binnavi.Gui.GraphWindows.NodeTaggingTree.Actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;


import com.google.common.base.Preconditions;
import com.google.security.zynamics.binnavi.Gui.GraphWindows.NodeTaggingTree.Implementations.CTagSelectionFunctions;
import com.google.security.zynamics.binnavi.Tagging.CTag;
import com.google.security.zynamics.binnavi.yfileswrap.zygraph.ZyGraph;
import com.google.security.zynamics.zylib.types.trees.ITreeNode;

/**
 * Action class used to select the visible nodes of a graph that are tagged with a given tag or any
 * of its child tags.
 */
public final class CSelectVisibleSubtreeNodesAction extends AbstractAction {
  /**
   * Used for serialization.
   */
  private static final long serialVersionUID = 3487079529580815369L;

  /**
   * The graph whose nodes are selected.
   */
  private final ZyGraph m_graph;

  /**
   * Nodes with this tag are selected.
   */
  private final ITreeNode<CTag> m_tag;

  /**
   * Creates a new action object.
   *
   * @param graph The graph whose nodes are selected.
   * @param tag Nodes with this tag are selected.
   */
  public CSelectVisibleSubtreeNodesAction(final ZyGraph graph, final ITreeNode<CTag> tag) {
    super("Select Visible Subtree Nodes");

    m_graph = Preconditions.checkNotNull(graph, "IE02319: Graph argument can not be null");
    m_tag = Preconditions.checkNotNull(tag, "IE02320: Tag can't be null");
  }

  @Override
  public void actionPerformed(final ActionEvent event) {
    CTagSelectionFunctions.selectVisibleSubtreeNodes(m_graph, m_tag);
  }
}
