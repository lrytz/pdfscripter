var pp = this.getPrintParams();
pp.interactive = pp.constants.interactionLevel.silent;
pp.printerName = "Microsoft XPS Document Writer";
this.print(pp);
