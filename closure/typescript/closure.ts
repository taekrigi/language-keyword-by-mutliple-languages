interface Player {
  name: string
  nation: string
  age: number
}

const players: Player[] = [
  {
    name: 'messi',
    nation: 'argentina',
    age: 33,
  },
  {
    name: 'ronaldo',
    nation: 'portugal',
    age: 35,
  },
  {
    name: 'son',
    nation: 'korea',
    age: 29,
  },
  {
    name: 'park',
    nation: 'korea',
    age: 39,
  },
]

const distinctBy = (property: string) => {
  const set = new Set()
  return (player: Player) =>
    set.has(player[property]) ? false : !!set.add(player[property])
}

const nations: string[] = players
  .filter(distinctBy('nation'))
  .map((player) => player.nation)

console.log(nations)
