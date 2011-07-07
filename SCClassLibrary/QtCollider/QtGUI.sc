QtGUI {

  *initClass {
    GUI.add( this );
  }

  *id { ^\qt }

  *stop { }

  *debugLevel_ { arg level;
    _QtGUI_SetDebugLevel
    ^this.primitiveFailed;
  }

  ///////////////////// redirection of GUI classes /////////////////////////////

  *view { ^QView }
  *compositeView { ^QView }
  *hLayoutView { ^QHLayoutView }
  *vLayoutView { ^QVLayoutView }
  *window { ^QWindow }
  *scrollView { ^QScrollView; }

  *staticText { ^QStaticText }
  *button { ^QButton; }
  *textField { ^QTextField }
  *numberBox { ^QNumberBox }
  *slider { ^QSlider }
  *multiSliderView { ^QMultiSliderView }
  *rangeSlider { ^QRangeSlider }
  *slider2D { ^QSlider2D }
  *tabletSlider2D { ^this.notImplemented( "TabletSlider2D"); }
  *knob { ^QKnob; }
  *listView { ^QListView }
  *popUpMenu { ^QPopUpMenu }
  *textView { ^QTextView; }

  *freqScope     { ^PlusFreqScopeWindow }
  *freqScopeView { ^PlusFreqScope }
  *scopeView { ^QScope }
  *stethoscope { ^QStethoscope }
  *soundFileView { ^QSoundFileView }
  *envelopeView { ^QEnvelopeView }
  *tabletView { ^this.notImplemented( "TabletView"); }
  *movieView { ^this.notImplemented( "MovieView"); }
  *levelIndicator { ^QLevelIndicator }
  *webView { ^QWebView }

  *userView { ^QUserView }

  *pen { ^QPen; }
  *font { ^QFont }

  *dragSource { ^QDragSource; }
  *dragSink { ^QDragSink; }
  *dragBoth { ^QDragBoth; }

  *dialog { ^QDialog }

  *ezScroller { ^EZScroller }
  *ezSlider { ^EZSlider }
  *ezListView { ^EZListView }
  *ezPopUpMenu { ^EZPopUpMenu}
  *ezNumber { ^EZNumber}
  *ezRanger { ^EZRanger }

  *notImplemented { arg class;
    ("QtGUI: " ++ class.asString ++ " is not implemented yet").postln;
    ^nil;
  }

  //////////////////////////////////////////////////////////////////////

  *availableStyles {
    _Qt_AvailableStyles
    ^this.primitiveFailed;
  }

  *style_ { arg styleName;
    _Qt_SetStyle
    ^this.primitiveFailed;
  }

  *stringBounds { arg aString, aFont;
    var bounds = this.prStringBounds( aString, aFont, Rect.new );
    bounds.left = 0;
    bounds.top = 0;
    ^bounds
  }

  *palette {
    ^this.prPalette( QPalette.new.init );
  }

  *palette_ { arg p;
    _Qt_SetGlobalPalette
    ^this.primitiveFailed;
  }

  *focusView {
    _Qt_FocusWidget
    ^this.primitiveFailed;
  }

  *selectedText {
    var view = this.focusView;
    if( view.notNil ) {
      if( view.respondsTo(\selectedText) ) { ^view.selectedText };
      if( view.respondsTo(\selectedString) ) { ^view.selectedString };
    };
    ^"";
  }

  // private ///////////////////////////////////////////////////////////

  *prPalette { arg ret;
    _Qt_GlobalPalette
    ^this.primitiveFailed;
  }

  *prStringBounds { arg aString, aFont, aRect;
    _Qt_StringBounds
    ^this.primitiveFailed
  }
}
