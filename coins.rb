def min_coins(change)
  min_coins = []
  available_coins = [10,5,1]
  index = 0

  while(change > 0) do
    coin = available_coins[index]
    if change - coin >= 0
      change -= coin
      min_coins << coin
    else
      index += 1
    end
  end

  min_coins
end

pp min_coins(31)
