$:.push File.expand_path("../lib", __FILE__)

# Maintain your gem's version:
require "oauth2_provider/version"

# Describe your gem and declare its dependencies:
Gem::Specification.new do |s|
  s.name        = "oauth2_provider"
  s.version     = Oauth2Provider::VERSION
  s.authors     = ["GoCD"]
  s.email       = ["go-cd-dev@googlegroups.com"]
  s.homepage    = "http://go.cd"
  s.summary     = "Engine to enable Go to understand OAuth2"
  s.description = "This engine implements v09 of the OAuth2 draft spec http://tools.ietf.org/html/draft-ietf-oauth-v2-09."

  s.files = Dir["{app,config,db,lib}/**/*", "MIT-LICENSE", "Rakefile", "README.rdoc"]
  s.extra_rdoc_files = ["README.textile", "MIT-LICENSE", "NOTICE.textile"]
  s.require_paths = ["lib"]

  s.add_dependency "rails", "~> 4.0.4"
  if s.respond_to? :specification_version then
    current_version = Gem::Specification::CURRENT_SPECIFICATION_VERSION
    s.specification_version = 3
    if Gem::Version.new(Gem::RubyGemsVersion) >= Gem::Version.new('1.2.0') then
      s.add_runtime_dependency(%q<validatable>, ["= 1.6.7"])
      s.add_development_dependency(%q<saikuro_treemap>, [">= 0"])
      s.add_development_dependency(%q<rcov>, ["= 0.9.8"])
    else
      s.add_dependency(%q<validatable>, ["= 1.6.7"])
      s.add_dependency(%q<saikuro_treemap>, [">= 0"])
      s.add_dependency(%q<rcov>, ["= 0.9.8"])
    end
  else
    s.add_dependency(%q<validatable>, ["= 1.6.7"])
    s.add_dependency(%q<saikuro_treemap>, [">= 0"])
    s.add_dependency(%q<rcov>, ["= 0.9.8"])
  end
end
