package de.tum.in.ase.eist.gameboard;

import java.util.*;

public abstract class Scene {

    public final GameBoard board;

    // needed to access entities by name
    private final Map<String, GameObject> tagMap = new HashMap<>();
    // all entities are stored here
    private final SortedMap<Integer, Set<GameObject>> gameObjects = new TreeMap<>();

    public Scene(GameBoard board) {
        this.board = board;
    }

    public Scene init() {
        tagMap.clear();
        gameObjects.clear();
        createBeginningObjects();
        return this;
    }

    protected abstract void createBeginningObjects();

    public void add(GameObject gameObject, String tag, int layer) {

        // set data
        gameObject.gameBoard = board;
        gameObject.tag = tag;
        gameObject.layer = layer;

        gameObject.onRegister();

        // add to entity management data structures
        gameObjects.computeIfAbsent(layer, HashSet::new).add(gameObject);
        if (tag != null)
            tagMap.put(tag, gameObject);

    }

    public void remove(GameObject gameObject) {
        if (gameObject.tag != null)
            tagMap.remove(gameObject.tag);
        gameObjects.get(gameObject.layer).remove(gameObject);
        gameObject.onRemove();
    }

    public <T extends GameObject> T getEntityByTag(String s) {
        GameObject obj = tagMap.get(s);
        if (obj == null) {
            return null;
        } else {
            return (T) obj;
        }
    }

    public GameObject[] getGamObjectArray() {
        return gameObjects.values().stream().flatMap(Set::stream).toArray(GameObject[]::new);
    }

}
