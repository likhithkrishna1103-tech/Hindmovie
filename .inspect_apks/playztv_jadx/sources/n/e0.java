package n;

import android.app.Activity;
import android.content.ClipData;
import android.os.Build;
import android.text.Selection;
import android.text.Spannable;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class e0 {
    public static boolean a(DragEvent dragEvent, TextView textView, Activity activity) {
        q0.c cVar;
        activity.requestDragAndDropPermissions(dragEvent);
        int offsetForPosition = textView.getOffsetForPosition(dragEvent.getX(), dragEvent.getY());
        textView.beginBatchEdit();
        try {
            Selection.setSelection((Spannable) textView.getText(), offsetForPosition);
            ClipData clipData = dragEvent.getClipData();
            if (Build.VERSION.SDK_INT >= 31) {
                cVar = new o4.c(clipData, 3);
            } else {
                q0.d dVar = new q0.d();
                dVar.f10429v = clipData;
                dVar.f10430w = 3;
                cVar = dVar;
            }
            q0.o0.j(textView, cVar.build());
            textView.endBatchEdit();
            return true;
        } catch (Throwable th) {
            textView.endBatchEdit();
            throw th;
        }
    }

    public static boolean b(DragEvent dragEvent, View view, Activity activity) {
        q0.c cVar;
        activity.requestDragAndDropPermissions(dragEvent);
        ClipData clipData = dragEvent.getClipData();
        if (Build.VERSION.SDK_INT >= 31) {
            cVar = new o4.c(clipData, 3);
        } else {
            q0.d dVar = new q0.d();
            dVar.f10429v = clipData;
            dVar.f10430w = 3;
            cVar = dVar;
        }
        q0.o0.j(view, cVar.build());
        return true;
    }
}
