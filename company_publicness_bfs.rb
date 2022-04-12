class Company
  attr_accessor :parent
  attr_reader :name, :is_public, :subsidiaries

  def initialize(name, is_public)
    @name = name
    @is_public = is_public
    @subsidiaries = []
  end

  def add_subsidiary(company)
    company.parent = self
    @subsidiaries << company
  end

  def public_hierarchy?
    ultimate_parent = find_ultimate_parent(self)
    return true if ultimate_parent.is_public
    bfs_is_public(ultimate_parent)
  end

  private
  def bfs_is_public(start_company)
    queue = start_company.subsidiaries
    while queue.any?
      company = queue.pop
      if company.is_public
        return true
      else
        queue += company.subsidiaries
      end
    end
  end

  def find_ultimate_parent(root)
    if root.parent
      find_ultimate_parent(root.parent)
    else
      root
    end
  end
end

alphabet = Company.new("AlphaBet", false)
google_mobile = Company.new("Google Mobile", false)
android = Company.new("Android", false)
waze = Company.new("Waze", true)
google_uk = Company.new("Google UK", false)

google_mobile.add_subsidiary(android)
google_mobile.add_subsidiary(waze)
alphabet.add_subsidiary(google_uk)
alphabet.add_subsidiary(google_mobile)

pp google_uk.public_hierarchy?
