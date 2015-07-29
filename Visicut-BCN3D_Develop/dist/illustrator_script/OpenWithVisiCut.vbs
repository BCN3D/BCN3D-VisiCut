'Exports the current document as SVG to dest
'dest contains the full path and file name to save to

destFile = "C:\temp\VCtemp.svg"
exportFileAsSVG (destFile)

Sub exportFileAsSVG (dest)
     Set appRef = CreateObject("Illustrator.Application")
     Set svgExportOptions = CreateObject("Illustrator.ExportOptionsSVG")
 
     If appRef.Documents.Count > 0 Then
          svgExportOptions.EmbedRasterImages = True
          svgExportOptions.FontSubsetting = 7 'aiAllGlyphs
          Set docRef = appRef.ActiveDocument
          Call docRef.Export (dest, 3, svgExportOptions) ' 3 = aiSVG
     End If
End Sub

'open document in VisiCut-BCN3D

strFileName = "C:\temp\VCtemp.svg"

set oShell = CreateObject("WScript.Shell")
oShell.Run """C:\Program Files (x86)\VisiCut-BCN3D\visicut-bcn3d.exe""" & strFileName