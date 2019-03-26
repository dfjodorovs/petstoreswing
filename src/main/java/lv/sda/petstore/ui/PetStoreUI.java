package lv.sda.petstore.ui;

import lv.sda.petstore.controllers.Management;
import lv.sda.petstore.models.AnimalDao;
import lv.sda.petstore.models.animal.AnimalType;

import javax.swing.*;
import java.awt.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Thread.sleep;

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
    private JPanel animalListMainPanel;
    private JPanel addAnimalsPanel;

    public PetStoreUI(Management management) {
        this.management = management;
    }

    public void generate() {

        JFrame frame = new JFrame();

        frame.setBounds(100,100,frameWidth,750);

        Component caretakerPanel = generateCaretakerPanel();
        caretakerPanel.setPreferredSize(new Dimension(frameWidth,60));

        addAnimalsPanel = generateAnimalsPanel();
        addAnimalsPanel.setVisible(false);
        addAnimalsPanel.setPreferredSize(new Dimension(frameWidth,150));

        animalListMainPanel = new JPanel();
        animalListMainPanel.setPreferredSize(new Dimension(frameWidth,500));

        Thread t = new Thread(()->{
            try {
                while (true) {
                    Thread.sleep(500);
                    generateAnimalsOnMainAnimalPanel();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t.start();

        frame.setLayout(new FlowLayout());

        frame.add(caretakerPanel);
        frame.add(addAnimalsPanel);
        frame.add(animalListMainPanel);
        frame.setVisible(true);

    }

    private JPanel generateAnimalsPanel() {
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

            generateAnimalsOnMainAnimalPanel();
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

    private void generateAnimalsOnMainAnimalPanel() {
        animalListMainPanel.removeAll();
        for (AnimalDao animalDao : management.getAnimalList()) {
            JPanel animalPanel = new JPanel();
            animalPanel.setPreferredSize(new Dimension(frameWidth,50));

            if(animalDao.getHealthLevel().getHealth() == 0){
                JLabel ripLabel = new JLabel("RIP");
                animalPanel.add(ripLabel);
                animalListMainPanel.add(animalPanel);
                continue;
            }

            JProgressBar foodBar = new JProgressBar();
            foodBar.setValue(animalDao.getHealthLevel().getFoodLevel());
            foodBar.setStringPainted(true);

            JProgressBar careBar = new JProgressBar();
            careBar.setValue(animalDao.getHealthLevel().getCareLevel());
            careBar.setStringPainted(true);

            JProgressBar healthBar = new JProgressBar();
            healthBar.setValue(animalDao.getHealthLevel().getHealth());
            healthBar.setStringPainted(true);

            JButton feedButton = new JButton("Feed");
            JButton careButton = new JButton("Care");

            feedButton.addActionListener(i->{
                management.feed(animalDao.getId());
            });

            careButton.addActionListener(i->{
                management.care(animalDao.getId());
            });

            animalPanel.add(new JLabel(animalDao.getName()));
            animalPanel.add(foodBar);
            animalPanel.add(careBar);
            animalPanel.add(healthBar);
            animalPanel.add(feedButton);
            animalPanel.add(careButton);
            animalListMainPanel.add(animalPanel);
        }
        animalListMainPanel.validate();
    }

    private Component generateCaretakerPanel() {
        JPanel panel = new JPanel();

        JLabel nameFieldLabel= new JLabel("Name: ");
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
            addAnimalsPanel.setVisible(true);
        });

        panel.add(nameFieldLabel);
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
