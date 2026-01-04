# 🚀 Mi-SpaceCraft

A modern **space exploration mod** for Minecraft, built on **NeoForge 1.21.11**.

> _Explore the cosmos, build space stations, and discover new worlds!_

---

## 📋 Overview

Mi-SpaceCraft is a modular and extensible Minecraft mod designed for space exploration. The project provides a solid foundation with:

- 🧱 **Custom Blocks** - Including machines with block entities
- 🔧 **Custom Items** - With special behaviors and effects
- 📦 **Inventory Systems** - Machine blocks with item storage
- 🎨 **Creative Tab** - All mod content in one place
- 🌍 **Dimension Support** - Framework for custom space dimensions (WIP)

---

## 🛠️ Technical Stack

| Component | Version       |
| --------- | ------------- |
| Minecraft | 1.21.11       |
| NeoForge  | 21.11.21-beta |
| Java      | 21            |
| Gradle    | 9.2.1         |

### Optional Dependencies

| Library    | Purpose                   | Status          |
| ---------- | ------------------------- | --------------- |
| **LDLib2** | UI components & data sync | Ready to enable |
| **JEI**    | Recipe viewing            | Ready to enable |

---

## 📁 Project Structure

```
src/main/java/com/lazzzzz/mispacecraft/
├── MiSpaceCraft.java           # Main mod class
├── MiSpaceCraftClient.java     # Client-side initialization
│
├── block/                      # Block implementations
│   ├── ExampleBlock.java       # Simple block
│   └── ExampleMachineBlock.java # Block with entity
│
├── blockentity/                # Block entities
│   └── ExampleMachineBlockEntity.java
│
├── item/                       # Item implementations
│   └── ExampleItem.java        # Item with custom behavior
│
├── core/                       # Core utilities
│   ├── registry/               # Deferred registries
│   │   ├── ModBlocks.java
│   │   ├── ModItems.java
│   │   ├── ModBlockEntities.java
│   │   └── ModCreativeTabs.java
│   └── util/
│       └── LanguageHelper.java # Translation key helper
│
└── compat/                     # Mod compatibility
    └── jei/
        └── MiSpaceCraftJEIPlugin.java
```

### Resources

```
src/main/resources/
├── META-INF/
│   └── neoforge.mods.toml      # Mod metadata
├── assets/mispacecraft/
│   ├── lang/
│   │   └── en_us.json          # English translations
│   └── textures/
│       ├── block/              # Block textures
│       └── item/               # Item textures
└── data/mispacecraft/          # Datapack content (recipes, tags, etc.)
```

---

## 🚀 Getting Started

### Prerequisites

- **Java 21** or higher
- **IDE** with Gradle support (IntelliJ IDEA recommended)

### Setup

1. **Clone the repository**

   ```bash
   git clone https://github.com/yourusername/Mi-SpaceCraft.git
   cd Mi-SpaceCraft
   ```

2. **Import into IDE**

   - Open the project folder in your IDE
   - Let Gradle sync (this may take a few minutes)

3. **Generate run configurations**
   ```bash
   ./gradlew genIntellijRuns  # For IntelliJ
   ./gradlew genEclipseRuns   # For Eclipse
   ```

### Running

```bash
# Build the mod
./gradlew build

# Run the client
./gradlew runClient

# Run the server
./gradlew runServer

# Run data generation
./gradlew runData
```

---

## 🎮 In-Game Content

### Blocks

| Block               | Description                                          |
| ------------------- | ---------------------------------------------------- |
| **Example Block**   | A simple decorative block                            |
| **Example Machine** | A machine with 9-slot inventory and processing logic |

### Items

| Item             | Description                                             |
| ---------------- | ------------------------------------------------------- |
| **Example Item** | Right-click to display a message, has 1-second cooldown |

### Creative Tab

All mod items are available in the **Mi-SpaceCraft** creative tab.

---

## 🔧 Adding New Content

### Adding a New Block

1. Create your block class in `block/`:

   ```java
   public class MyBlock extends Block {
       public MyBlock(Properties properties) {
           super(properties);
       }
   }
   ```

2. Register it in `ModBlocks.java`:

   ```java
   public static final DeferredBlock<Block> MY_BLOCK = BLOCKS.registerBlock(
       "my_block",
       MyBlock::new,
       BlockBehaviour.Properties.of().strength(3.0f)
   );
   ```

3. Add block item in the static block:

   ```java
   static {
       ModItems.ITEMS.registerSimpleBlockItem("my_block", MY_BLOCK);
   }
   ```

4. Add texture: `assets/mispacecraft/textures/block/my_block.png`

5. Add translation in `en_us.json`:
   ```json
   "block.mispacecraft.my_block": "My Block"
   ```

### Adding a New Item

1. Create your item class in `item/`:

   ```java
   public class MyItem extends Item {
       public MyItem(Properties properties) {
           super(properties);
       }
   }
   ```

2. Register it in `ModItems.java`:

   ```java
   public static final DeferredItem<Item> MY_ITEM = ITEMS.registerItem(
       "my_item",
       MyItem::new,
       new Item.Properties().stacksTo(64)
   );
   ```

3. Add texture: `assets/mispacecraft/textures/item/my_item.png`

4. Add translation in `en_us.json`

---

## 📦 Enabling Optional Dependencies

### LDLib2 (UI Library)

1. Find the latest version at [Maven](https://maven.firstdark.dev/snapshots/com/lowdragmc/ldlib2/)

2. Add to `gradle.properties`:

   ```properties
   ldlib2_version=YOUR_VERSION
   ```

3. Uncomment in `build.gradle`:
   ```gradle
   implementation("com.lowdragmc.ldlib2:ldlib2-neoforge-${minecraft_version}:${ldlib2_version}:all") { transitive = false }
   compileOnly("org.appliedenergistics.yoga:yoga:1.0.0")
   ```

### JEI (Just Enough Items)

1. Find the version for MC 1.21.11 at [CurseForge](https://www.curseforge.com/minecraft/mc-mods/jei/files)

2. Uncomment in `build.gradle`:

   ```gradle
   compileOnly "mezz.jei:jei-${minecraft_version}-common-api:VERSION"
   compileOnly "mezz.jei:jei-${minecraft_version}-neoforge-api:VERSION"
   localRuntime "mezz.jei:jei-${minecraft_version}-neoforge:VERSION"
   ```

3. Uncomment the code in `MiSpaceCraftJEIPlugin.java`

---

## 🗺️ Roadmap

- [ ] **Space Dimension** - Custom dimension with unique generation
- [ ] **Moon Biome** - Barren, grey landscape with craters
- [ ] **Rockets** - Travel between dimensions
- [ ] **Space Stations** - Build in zero gravity
- [ ] **Oxygen System** - Survival mechanics in space
- [ ] **Planets** - Multiple celestial bodies to explore
- [ ] **Space Suits** - Protection in hostile environments

---

## 📝 License

This project is licensed under the **MIT License** - see the [LICENSE](LICENSE) file for details.

---

## 👥 Credits

- **Author**: Lazzzzz
- **Framework**: NeoForge Team
- **Inspiration**: Space exploration mods like Galacticraft, Ad Astra

---

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

---

<p align="center">
  <i>Made with ❤️ for the Minecraft modding community</i>
</p>
