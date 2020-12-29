const players = [
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

const distinctBy = (property) => {
  const set = new Set()
  return (player) =>
    set.has(player[property]) ? false : !!set.add(player[property])
}

const nations = players
  .filter(distinctBy('nation'))
  .map((player) => player.nation)

console.log(nations)
