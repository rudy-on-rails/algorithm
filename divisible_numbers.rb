def divisibleNumbers(n)
    max = n ** n
    nbr = nil
    attempt = n
    count = 0
    while (nbr == nil && attempt <= max) do
        splitted = attempt.to_s.split('')
        nbr = attempt if attempt % n == 0 && !splitted.include?('0') &&
            splitted.sum{|a| a.to_i} >= splitted.reduce{|x,y| x.to_i * y.to_i}.to_i
        attempt = n * count
        attempt = attempt.to_s.split('').map{|x| x == '0' ? 1 : x.to_i}.join.to_i
        puts attempt
        count+=1
    end
    nbr.to_s.length
end

puts divisibleNumbers(55)
