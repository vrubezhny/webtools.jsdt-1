/*******************************************************************************
 * Copyright (c) 2000, 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.wst.jsdt.core.tests.dom;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.wst.jsdt.core.dom.*;
import org.eclipse.wst.jsdt.core.dom.ASTVisitor;

class ASTNodesCollectorVisitor extends ASTVisitor {
	
	private Set detachedAstNodes;
	
	/**
	 * 
	 * @see java.lang.Object#Object()
	 */
	ASTNodesCollectorVisitor() {
        // visit Javadoc.tags()
		super(true); 
		this.detachedAstNodes = new HashSet();
	}

	private void add(ASTNode node) {
		this.detachedAstNodes.add(node);
	}
		
	/**
	 * @see org.eclipse.wst.jsdt.core.dom.ASTVisitor#endVisit(AnnotationTypeDeclaration)
	 * @since 3.0
	 */
	public void endVisit(AnnotationTypeDeclaration node) {
		add(node);
		node.setName(node.getAST().newSimpleName("XXX")); //$NON-NLS-1$
		detachedListElement(node.bodyDeclarations());
	}

	/**
	 * @see org.eclipse.wst.jsdt.core.dom.ASTVisitor#endVisit(AnnotationTypeMemberDeclaration)
	 * @since 3.0
	 */
	public void endVisit(AnnotationTypeMemberDeclaration node) {
		node.setName(node.getAST().newSimpleName("XXX")); //$NON-NLS-1$
	}

	/**
	 * @see org.eclipse.wst.jsdt.core.dom.ASTVisitor#endVisit(org.eclipse.wst.jsdt.core.dom.AnonymousClassDeclaration)
	 */
	public void endVisit(AnonymousClassDeclaration node) {
		add(node);
		detachedListElement(node.bodyDeclarations());
	}

	private void detachedListElement(List list) {
		for (int i = 0; i < list.size(); i++) {
			list.remove(0);
		}
	}

	/**
	 * @see org.eclipse.wst.jsdt.core.dom.ASTVisitor#endVisit(org.eclipse.wst.jsdt.core.dom.ClassInstanceCreation)
	 * @deprecated using deprecated code
	 */
	public void endVisit(ClassInstanceCreation node) {
		if (node.getAST().apiLevel() == AST.JLS2) {
			node.setName(
					node.getAST().newSimpleName("XXX")); //$NON-NLS-1$
		}
	}

	/**
	 * @see org.eclipse.wst.jsdt.core.dom.ASTVisitor#endVisit(org.eclipse.wst.jsdt.core.dom.JavaScriptUnit)
	 */
	public void endVisit(JavaScriptUnit node) {
		detachedListElement(node.imports());
		node.setPackage(node.getAST().newPackageDeclaration());
	}

	/**
	 * @see org.eclipse.wst.jsdt.core.dom.ASTVisitor#endVisit(EnumConstantDeclaration)
	 * @since 3.0
	 */
	public void endVisit(EnumConstantDeclaration node) {
		add(node);
		node.setName(node.getAST().newSimpleName("XXX")); //$NON-NLS-1$
		detachedListElement(node.getAnonymousClassDeclaration().bodyDeclarations());
	}

	/**
	 * @see org.eclipse.wst.jsdt.core.dom.ASTVisitor#endVisit(EnumDeclaration)
	 * @since 3.0
	 */
	public void endVisit(EnumDeclaration node) {
		add(node);
		node.setName(node.getAST().newSimpleName("XXX")); //$NON-NLS-1$
		detachedListElement(node.bodyDeclarations());
	}

	/**
	 * @see org.eclipse.wst.jsdt.core.dom.ASTVisitor#endVisit(org.eclipse.wst.jsdt.core.dom.FieldAccess)
	 */
	public void endVisit(FieldAccess node) {
		node.setName(node.getAST().newSimpleName("XXX")); //$NON-NLS-1$
	}

	/**
	 * @see org.eclipse.wst.jsdt.core.dom.ASTVisitor#endVisit(org.eclipse.wst.jsdt.core.dom.FieldDeclaration)
	 */
	public void endVisit(FieldDeclaration node) {
		detachedListElement(node.fragments());
	}

	/**
	 * @see org.eclipse.wst.jsdt.core.dom.ASTVisitor#endVisit(org.eclipse.wst.jsdt.core.dom.ImportDeclaration)
	 */
	public void endVisit(ImportDeclaration node) {
		add(node);
		node.setName(node.getAST().newSimpleName("XXX")); //$NON-NLS-1$
	}

	/**
	 * @see ASTVisitor#endVisit(MemberRef)
	 * @since 3.0
	 */
	public void endVisit(MemberRef node) {
		add(node);
	}

	/**
	 * @see org.eclipse.wst.jsdt.core.dom.ASTVisitor#endVisit(org.eclipse.wst.jsdt.core.dom.FunctionDeclaration)
	 */
	public void endVisit(FunctionDeclaration node) {
		node.setName(node.getAST().newSimpleName("XXX")); //$NON-NLS-1$
	}

	/**
	 * @see org.eclipse.wst.jsdt.core.dom.ASTVisitor#endVisit(org.eclipse.wst.jsdt.core.dom.FunctionInvocation)
	 */
	public void endVisit(FunctionInvocation node) {
		add(node);
		node.setName(node.getAST().newSimpleName("XXX")); //$NON-NLS-1$
	}

	/**
	 * @see ASTVisitor#endVisit(FunctionRef)
	 * @since 3.0
	 */
	public void endVisit(FunctionRef node) {
		add(node);
	}

	/**
	 * @see org.eclipse.wst.jsdt.core.dom.ASTVisitor#endVisit(org.eclipse.wst.jsdt.core.dom.PackageDeclaration)
	 */
	public void endVisit(PackageDeclaration node) {
		add(node);
		node.setName(node.getAST().newSimpleName("XXX")); //$NON-NLS-1$
	}

	/**
	 * @see org.eclipse.wst.jsdt.core.dom.ASTVisitor#endVisit(org.eclipse.wst.jsdt.core.dom.QualifiedName)
	 */
	public void endVisit(QualifiedName node) {
		add(node);
		node.setQualifier(node.getAST().newSimpleName("sss")); //$NON-NLS-1$
		node.setName(node.getAST().newSimpleName("sss")); //$NON-NLS-1$
	}

	/**
	 * @see org.eclipse.wst.jsdt.core.dom.ASTVisitor#endVisit(org.eclipse.wst.jsdt.core.dom.SimpleName)
	 */
	public void endVisit(SimpleName node) {
		ASTNode parent = node.getParent();
		switch(parent.getNodeType()) {
			case ASTNode.CONTINUE_STATEMENT :
			case ASTNode.BREAK_STATEMENT :
			case ASTNode.LABELED_STATEMENT :
				break;
			default :
				add(node);
		}
	}

	/**
	 * @see org.eclipse.wst.jsdt.core.dom.ASTVisitor#endVisit(org.eclipse.wst.jsdt.core.dom.SimpleType)
	 */
	public void endVisit(SimpleType node) {
		node.setName(node.getAST().newSimpleName("XXX")); //$NON-NLS-1$
	}

	/**
	 * @see org.eclipse.wst.jsdt.core.dom.ASTVisitor#endVisit(org.eclipse.wst.jsdt.core.dom.SingleVariableDeclaration)
	 */
	public void endVisit(SingleVariableDeclaration node) {
		node.setName(node.getAST().newSimpleName("XXX")); //$NON-NLS-1$
	}

	/**
	 * @see org.eclipse.wst.jsdt.core.dom.ASTVisitor#endVisit(org.eclipse.wst.jsdt.core.dom.SuperFieldAccess)
	 */
	public void endVisit(SuperFieldAccess node) {
		node.setName(node.getAST().newSimpleName("XXX")); //$NON-NLS-1$
		node.setQualifier(node.getAST().newSimpleName("XXX")); //$NON-NLS-1$
	}

	/**
	 * @see org.eclipse.wst.jsdt.core.dom.ASTVisitor#endVisit(org.eclipse.wst.jsdt.core.dom.SuperMethodInvocation)
	 */
	public void endVisit(SuperMethodInvocation node) {
		node.setName(node.getAST().newSimpleName("XXX")); //$NON-NLS-1$
		node.setQualifier(node.getAST().newSimpleName("XXX")); //$NON-NLS-1$
	}

	/**
	 * @see org.eclipse.wst.jsdt.core.dom.ASTVisitor#endVisit(org.eclipse.wst.jsdt.core.dom.ThisExpression)
	 */
	public void endVisit(ThisExpression node) {
		node.setQualifier(node.getAST().newSimpleName("XXX")); //$NON-NLS-1$
	}

	/**
	 * @see org.eclipse.wst.jsdt.core.dom.ASTVisitor#endVisit(org.eclipse.wst.jsdt.core.dom.TypeDeclaration)
	 * @deprecated using deprecated code
	 */
	public void endVisit(TypeDeclaration node) {
		add(node);
		node.setName(node.getAST().newSimpleName("XXX")); //$NON-NLS-1$
		if (node.getAST().apiLevel() == AST.JLS2) {
			node.setSuperclass(node.getAST().newSimpleName("XXX")); //$NON-NLS-1$
		}
		detachedListElement(node.bodyDeclarations());
	}

	/**
	 * @see org.eclipse.wst.jsdt.core.dom.ASTVisitor#endVisit(org.eclipse.wst.jsdt.core.dom.VariableDeclarationExpression)
	 */
	public void endVisit(VariableDeclarationExpression node) {
		detachedListElement(node.fragments());
	}

	/**
	 * @see org.eclipse.wst.jsdt.core.dom.ASTVisitor#endVisit(org.eclipse.wst.jsdt.core.dom.VariableDeclarationFragment)
	 */
	public void endVisit(VariableDeclarationFragment node) {
		add(node);
		node.setName(node.getAST().newSimpleName("XXX")); //$NON-NLS-1$
	}

	/**
	 * @see org.eclipse.wst.jsdt.core.dom.ASTVisitor#endVisit(org.eclipse.wst.jsdt.core.dom.VariableDeclarationStatement)
	 */
	public void endVisit(VariableDeclarationStatement node) {
		detachedListElement(node.fragments());
	}

	/**
	 * Returns the detachedAstNodes.
	 * @return Set
	 */
	public Set getDetachedAstNodes() {
		return detachedAstNodes;
	}

}
