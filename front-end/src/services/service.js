export function getMortgages() {
  return fetch('http://localhost:8080/mortgages', {
      method: 'get'
  }).then(data => data.json())
}

export function addProspects(prospect) {
  let isFailed = false;
  fetch('http://localhost:8080/prospects', {
    method: 'post',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({fullName: prospect.fullName, totalLoan: prospect.totalLoan, interest: prospect.interest, years: prospect.years})
  }).catch(() => isFailed = true)
  return isFailed;
}
