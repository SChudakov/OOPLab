package com.sschudakov.tables.table_view;

import com.sschudakov.gui.GBC;
import com.sschudakov.tables.expression_parsing.Expression;
import com.sschudakov.tables.expression_parsing.ExpressionTree;
import com.sschudakov.tables.expression_parsing.LexicalAnalyzer;
import com.sschudakov.tables.expression_parsing.SyntaxAnalyzer;
import com.sschudakov.utils.ExceptionRenderer;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Created by Semen Chudakov on 05.11.2017.
 */
public class TableViewManager {
    private JFrame frame = new JFrame("Table Viewer");
    private JPanel tablePanel = new JPanel();
    private JPanel labelsPanel = new JPanel();
    private JMenuBar menuBar = new JMenuBar();


    private JTextField expressionLabel = new JTextField();
    private JTextField rowTextFiled = new JTextField();
    private JTextField columnTextField = new JTextField();

    private JTable table;
    private DefaultTableModel tableModel;
    private JScrollPane tableScrollPane;

    private LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer();
    private SyntaxAnalyzer syntaxAnalyzer = new SyntaxAnalyzer(lexicalAnalyzer);
    private ExpressionTree expressionTree = new ExpressionTree();

    public TableViewManager(JTable table) {
        this.table = table;
        this.tableModel = (DefaultTableModel) table.getModel();
        this.tableScrollPane = new JScrollPane(table);
    }

    public void buildTableView() {

        setupFrame();

        setupPanels();

        setupScrollPane();

        setupTextFields();

        setupTable();

        this.frame.setVisible(true);
    }

    private void setupFrame() {


        int screenHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        int screenWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();

        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setLocationByPlatform(true);
        this.frame.setLayout(new GridBagLayout());
        this.frame.setSize(screenWidth * 8 / 10, screenHeight * 8 / 10);

        this.frame.add(this.tablePanel, new GBC(0, 0, 1, 1, 1, 1, GridBagConstraints.BOTH));
        this.frame.add(this.labelsPanel, new GBC(0, 1, 1, 1, 0.2, 0.2, GridBagConstraints.BOTH));
    }

    private void setupPanels() {

        GridBagLayout tablePanelLayout = new GridBagLayout();

        this.tablePanel.setBorder(BorderFactory.createTitledBorder(
                new LineBorder(Color.BLACK, 1, true), "Table"));
        this.tablePanel.setLayout(tablePanelLayout);
        this.tablePanel.add(this.tableScrollPane,
                new GBC(0, 0, 1, 1, 1, 1, GridBagConstraints.BOTH));

        GridBagLayout labelsPanelLayout = new GridBagLayout();

        this.labelsPanel.setBorder(BorderFactory.createTitledBorder(
                new LineBorder(Color.BLACK, 1, true), "Text Fields"));
        this.labelsPanel.setLayout(labelsPanelLayout);
        this.labelsPanel.add(this.rowTextFiled,
                new GBC(0, 0, 1, 1, 0.2, 0.2, GridBagConstraints.BOTH));
        this.labelsPanel.add(this.columnTextField,
                new GBC(1, 0, 1, 1, 0.2, 0.2, GridBagConstraints.BOTH));
        this.labelsPanel.add(this.expressionLabel,
                new GBC(2, 0, 1, 1, 0.8, 0.8, GridBagConstraints.BOTH));
    }

    private void setupScrollPane() {
        this.tableScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.tableScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    }

    private void setupTextFields() {
        this.expressionLabel.setBorder(BorderFactory.createTitledBorder(
                new LineBorder(Color.BLACK, 1, true), "Expression"));
        this.rowTextFiled.setBorder(BorderFactory.createTitledBorder(
                new LineBorder(Color.BLACK, 1, true), "Row"));
        this.columnTextField.setBorder(BorderFactory.createTitledBorder(
                new LineBorder(Color.BLACK, 1, true), "Column"));
    }

    private void setupTable() {
        this.table.setAutoCreateRowSorter(true);
        this.table.setCellSelectionEnabled(true);
        this.tableModel.addTableModelListener(new TableListener());
    }


    public class TableListener implements TableModelListener {

        @Override
        public void tableChanged(TableModelEvent e) {

            System.out.println("Event: " + e.toString());

            int row = e.getFirstRow();
            int column = e.getColumn();

            String expression = (String) tableModel.getValueAt(row, column);
            TableCell cell = new TableCell();

            lexicalAnalyzer.setExpression(new Expression(expression));
            expressionTree.setHead(syntaxAnalyzer.expression());

            Object value = null;
            try {
                value = expressionTree.evaluate();
            } catch (Exception e1) {
                ExceptionRenderer.renderException(frame, e1);
            }
            cell.setValue(value.toString());
            cell.setExpression(expression);

            table.setValueAt(cell, row, column);


        }
    }
}