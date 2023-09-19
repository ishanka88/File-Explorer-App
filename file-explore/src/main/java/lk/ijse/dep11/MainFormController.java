package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class MainFormController {
    public TreeView treeView;
    public AnchorPane root;
    public Button btnNewFolder;
    public Button btnCopy;
    public Button btnCut;
    public Button btnPaste;
    public Button btnRename;
    public Button btnNewFile;
    public ListView lstView;
    public CheckBox ckboxShowHiddenFiles;

    String property = System.getProperty("user.name");
    File rootPath = new File("/home/" + property);
    TreeItem<String> rootTree = new TreeItem<>(rootPath.getName());


    public void initialize() {
        rootTree.getChildren().clear();
        setTreeView(rootTree, rootPath);
        treeView.setRoot(rootTree);
        rootTree.setExpanded(true);
    }

    public void btnNewFolderOnAction(ActionEvent actionEvent) {
    }

    public void btnCopyOnAction(ActionEvent actionEvent) {
    }

    public void btnCutOnAction(ActionEvent actionEvent) {
    }

    public void btnPasteOnAction(ActionEvent actionEvent) {
    }

    public void btnRenameOnAction(ActionEvent actionEvent) {
    }

    public void btnNewFileOnAction(ActionEvent actionEvent) {
    }

    public void ckboxShowHiddenFilesOnAction(ActionEvent actionEvent) {
            initialize();
    }

    public void setTreeView(TreeItem item , File filePath) {
        File[] filesList = filePath.listFiles();
        for (File file : filesList) {
            if (file.getName().charAt(0) == '.' && !ckboxShowHiddenFiles.isSelected()) continue; // hidden files
//            if (file.isDirectory()) System.out.println(file.getName() + "    Directory");
//            if (file.isFile()) System.out.println(file.getName() + "   File");
            TreeItem<String> newItem = new TreeItem<>(file.getName());
            item.getChildren().add(newItem);
            if (file.isDirectory()) {
                setTreeView(newItem , file);
            }
        }
    }

}