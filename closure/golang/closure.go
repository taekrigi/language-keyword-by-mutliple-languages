package main

import (
	"fmt"
)

type Player struct {
	name	string
	nation	string
	age		int
}

func (p Player) GetValueByProperty(property string) interface{} {
	switch property {
		case "name": return p.name
		case "nation": return p.nation
		case "age": return p.age
		default: return nil
	}
}

func (p Player) getNation() string {
	return p.nation
}

var players = []Player {
	Player{
		name: "messi",
		nation: "argentina",
		age: 33,
	},
	Player{
		name: "ronaldo",
		nation: "portugal",
		age: 35,
	},
	Player{
		name: "son",
		nation: "korea",
		age: 29,
	},
	Player{
		name: "park",
		nation: "korea",
		age: 39,
	},
}

func Filter(players []Player, callback func(Player) bool) []Player {
	result := []Player{}

	for _, v := range players {
		if (callback (v)) {
			result = append(result, v)
		}
	}

	return result
}

func Map(players []Player, callback func(Player) string) []string {
	result := []string{}

	for _, v := range players {
		result = append(result, callback(v))
	}

	return result
} 

func DistinctBy(key string) func(player Player) bool {
	store := map[interface{}]interface{}{}
	return func(player Player) bool {
		value := player.GetValueByProperty(key)
		
		if (value == nil) {
			return false
		}

		if (store[value] == true) {
			return false
		}

		store[value] = true		

		return true
	}
}

func main() {
	playersFilteredByNation := Filter(players, DistinctBy("nation"))
	nations := Map(playersFilteredByNation, func(player Player) string {
		return player.getNation()
	})

	fmt.Println(nations)
}