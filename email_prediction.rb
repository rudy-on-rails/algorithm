class EmailsDatabase
  def read
    {
      "Google" => ["s.bring@google.com", "larry.p@google.com "],
      "Apple" => ["s.jobs@apple.com"],
      "Stripe" => ["patrick.collison@stripe.com"],
      "Heroku" => ["a.b@heroku.com","adam.briggs@heroku.com"],
      "AlphaSights" => ["david@alphasights.com"]
    }
  end
end

class EmailPredictor
  def initialize(db=EmailsDatabase.new)
    @source = db.read
  end

  def predict(company, name)
    patterns = @source[company]
    if patterns.nil?
      raise "Pattern not found for #{company}"
    else
      predict_using_patterns(patterns, name.downcase, company)
    end
  end

  private
  def predict_using_patterns(patterns, name, company)
    name_surnames = name.split(" ")
    patterns.map do |pattern|
      pattern_division = pattern.split("@")[0].split(".")
      email_part = if pattern_division.size == 1
        "#{name.split(" ").join('.')}"
      elsif pattern_division[0].length == 1 && pattern_division[1].length > 1
        "#{name_surnames[0][0]}.#{name_surnames[1..].join("")}"
      elsif pattern_division[1].length == 1 && pattern_division[0].length > 1
        "#{name_surnames[0]}.#{name_surnames[1..].map{|c| c[0]}.join("")}"
      elsif pattern_division[0].length == 1 && pattern_division[1].length == 1
        "#{name_surnames[0][0]}.#{name_surnames[1..].map{|c| c[0]}.join(".")}"
      elsif pattern_division[0].length > 1 && pattern_division[1].length > 1
        "#{name_surnames[0]}.#{name_surnames[1..].join(".")}"
      end
      "#{email_part}@#{company.downcase}.com"
    end
  end
end

puts EmailPredictor.new.predict("Google", "Rudy Wagner Seidinger")
puts "-----"
puts EmailPredictor.new.predict("Heroku", "Rudy Wagner Seidinger")
puts "-----"
puts EmailPredictor.new.predict("AlphaSights", "Rudy Wagner Seidinger")

