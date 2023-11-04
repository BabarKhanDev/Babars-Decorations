files = ["blockstates/oak_trellis.json","models/item/oak_trellis.json" ,"models/block/oak_trellis.json", "models/block/oak_trellis_azalea_leaves.json", "models/block/oak_trellis_flowering_azalea_leaves.json", "models/block/oak_trellis_lilac.json", "models/block/oak_trellis_moss.json", "models/block/oak_trellis_peony.json", "models/block/oak_trellis_rose.json", "models/block/oak_trellis_twisting.json", "models/block/oak_trellis_vine.json", "models/block/oak_trellis_weeping.json"]
woods = ["spruce", "jungle", "birch", "acacia", "dark_oak", "warped", "crimson", "mangrove", "cherry", "bamboo"]

for filename in files:
    for wood in woods:
        with open(f"../src/main/resources/assets/babarsdecorations/{filename}") as my_file:
            lines = my_file.readlines()
            with open(f"../src/main/resources/assets/babarsdecorations/{filename.replace('oak', wood)}", 'w') as f:
                for line in lines:
                    f.write(f"{line.replace('oak', wood)}") 

for wood in woods:
    files = ["data/babarsdecorations/loot_tables/blocks/oak_trellis.json", "data/babarsdecorations/recipes/oak_trellis.json"]      
    for filename in files:
        with open(f"../src/main/resources/{filename}") as my_file:
            lines = my_file.readlines()
            with open(f"../src/main/resources/{filename.replace('oak', wood)}", 'w') as f:
                for line in lines:
                    f.write(f"{line.replace('oak', wood)}") 
