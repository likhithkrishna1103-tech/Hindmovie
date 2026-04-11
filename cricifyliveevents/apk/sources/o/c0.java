package o;

import android.app.Activity;
import android.content.ClipData;
import android.os.Build;
import android.text.Selection;
import android.text.Spannable;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c0 {
    public static boolean a(DragEvent dragEvent, TextView textView, Activity activity) {
        t0.c eVar;
        activity.requestDragAndDropPermissions(dragEvent);
        int offsetForPosition = textView.getOffsetForPosition(dragEvent.getX(), dragEvent.getY());
        textView.beginBatchEdit();
        try {
            Selection.setSelection((Spannable) textView.getText(), offsetForPosition);
            ClipData clipData = dragEvent.getClipData();
            if (Build.VERSION.SDK_INT >= 31) {
                eVar = new m2.e(clipData, 3);
            } else {
                t0.d dVar = new t0.d();
                dVar.f11738w = clipData;
                dVar.f11739x = 3;
                eVar = dVar;
            }
            t0.m0.j(textView, eVar.build());
            textView.endBatchEdit();
            return true;
        } catch (Throwable th) {
            textView.endBatchEdit();
            throw th;
        }
    }

    public static boolean b(DragEvent dragEvent, View view, Activity activity) {
        t0.c eVar;
        activity.requestDragAndDropPermissions(dragEvent);
        ClipData clipData = dragEvent.getClipData();
        if (Build.VERSION.SDK_INT >= 31) {
            eVar = new m2.e(clipData, 3);
        } else {
            t0.d dVar = new t0.d();
            dVar.f11738w = clipData;
            dVar.f11739x = 3;
            eVar = dVar;
        }
        t0.m0.j(view, eVar.build());
        return true;
    }
}
