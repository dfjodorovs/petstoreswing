package lv.sda.petstore.ui;

import lv.sda.petstore.controllers.Management;
import lv.sda.petstore.models.AnimalDao;
import lv.sda.petstore.models.animal.AnimalType;

import javax.swing.*;
import java.awt.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*

Loads a screen with buttons that have add animal(choose type of animal)
Must be a place where to input Caretakers name, and add him, after that allowed to add animal
After adding animal animal appears on the screen with it's health level
There need to be buttons to feed and care for animal
Health level decreases over time
 */
public class PetStoreUI implements UIGenerator{

    private final int frameWidth = 1000;
    private Management management;

    public PetStoreUI(Management management) {
        this.management = management;
    }

    public void generate() {

        JFrame frame = new JFrame();

        frame.setBounds(100,100,frameWidth,750);

        Component caretakerPanel = generateCaretakerPanel();
        Component addAnimalsPanel = generateAnimalsPanel();
        Component addAnimalsListPanel = generateAnimalsListPanel();
        BorderLayout borderLayout = new BorderLayout();
        frame.setLayout(borderLayout);

        frame.add(caretakerPanel, BorderLayout.PAGE_START);
        frame.add(addAnimalsPanel, BorderLayout.CENTER);
        frame.add(addAnimalsListPanel, BorderLayout.PAGE_END);
        frame.setVisible(true);
    }

    private Component generateAnimalsListPanel() {
        JPanel mainPanel = new JPanel();
        List<AnimalDao> animalList = management.getAnimalList();

        return mainPanel;
    }

    private Component generateAnimalsPanel() {
        // llink in chat about image
        // add animal button -> reads the selected radio button, calls managemen class
        // to create selected animal
        JPanel panel = new JPanel();
        FlowLayout mgr = new FlowLayout();
        mgr.setAlignment(FlowLayout.LEFT);
        panel.setLayout(mgr);

        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton parrotRadioButton = new JRadioButton("Parrot really loud one");
        JRadioButton catRadioButton = new JRadioButton("Cat furry");
        JButton addAnimalButton = new JButton("add");

        Map<JRadioButton,AnimalType> jRadioButtonAnimalTypeMap = new HashMap<>();
        jRadioButtonAnimalTypeMap.put(parrotRadioButton,AnimalType.PARROT);
        jRadioButtonAnimalTypeMap.put(catRadioButton,AnimalType.CAT);
        addAnimalButton.addActionListener(a->{
            management.createAnimal(
                    jRadioButtonAnimalTypeMap.get(
                            getSelectedButtonText(buttonGroup)));
        });

        ImageIcon image = new ImageIcon(
                new ImageIcon(
                    getClass().getClassLoader().getResource("download.jpg"))
                        .getImage()
                        .getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        JLabel parrotPictureLabel = new JLabel(image);

        buttonGroup.add(parrotRadioButton);
        buttonGroup.add(catRadioButton);

        panel.add(parrotPictureLabel);
        panel.add(parrotRadioButton);
        panel.add(addAnimalButton);

        return panel;
    }

    private Component generateCaretakerPanel() {
        JPanel panel = new JPanel();

        JTextField nameField = new JTextField("",20);
        JButton addNameButton = new JButton("Add");
        JButton editNameButton = new JButton("Edit");
        editNameButton.setVisible(false);

        editNameButton.addActionListener(i->{
            if(nameField.isEnabled()){
                management.changeCaretaker(nameField.getText());
            }
            nameField.setEnabled(!nameField.isEnabled());
        });

        addNameButton.addActionListener((i)->{
            management.createCaretaker(nameField.getText());
            nameField.setEnabled(false);
            addNameButton.setVisible(false);
            editNameButton.setVisible(true);
        });

        panel.add(nameField);
        panel.add(addNameButton);
        panel.add(editNameButton);
        FlowLayout mgr = new FlowLayout();
        mgr.setAlignment(FlowLayout.LEFT);
        panel.setLayout(mgr);
        return panel;
    }

    private JRadioButton getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return (JRadioButton) button;
            }
        }

        return null;
    }
}
