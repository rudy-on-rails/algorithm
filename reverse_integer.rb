def reverse(x)
  chars = x.to_s
  neg = chars[0] == "-"
  new_nbr = chars.reverse.to_i * (neg ? -1 : 1)
  new_nbr.abs < 2147483647 ? new_nbr : 0
end

pp reverse(-123)
pp reverse(120)
