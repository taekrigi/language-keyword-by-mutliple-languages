class Player:
    def __init__(self, name, nation, age):
        self._name = name
        self._nation = nation
        self._age = age

    def get_name(self):
        return self._name
    
    def get_nation(self):
        return self._nation
    
    def get_age(self):
        return self._age
    
    def get_value_by_property(self, prop):
        switcher = {
            "name": self.get_name(),
            "nation": self.get_nation(),
            "age": self.get_age()
        }

        return switcher.get(prop)

def distinct_by(prop): 
    store = set()

    def has_score(player):
        value = player.get_value_by_property(prop)
        
        if value == None: 
            return False

        if value in store:
            return False

        store.add(value)

        return True

    return has_score

def get_nation(player):
    return player.get_nation()

players = [
    Player("messi", "argentina", 33),
    Player("ronaldo", "portugal", 35),
    Player("son", "korea", 29),
    Player("park", "korea", 39)
]

player_filtered_by_nation = list(filter(distinct_by("nation"), players))
nations = list(map(get_nation, player_filtered_by_nation))

print(nations)