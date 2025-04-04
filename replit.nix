{ pkgs }: {
  deps = [
    pkgs.openjdk19  # Make sure OpenJDK 19 is installed
    pkgs.maven      # Make sure Maven is installed
  ];
}
