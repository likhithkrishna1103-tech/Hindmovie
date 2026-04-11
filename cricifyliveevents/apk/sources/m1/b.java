package m1;

import android.os.Bundle;
import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
import androidx.emoji2.text.m;
import f9.z;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends InputConnectionWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EditText f8021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z f8022b;

    public b(EditText editText, InputConnection inputConnection, EditorInfo editorInfo) {
        z zVar = new z(17);
        super(inputConnection, false);
        this.f8021a = editText;
        this.f8022b = zVar;
        if (m.f863k != null) {
            m mVarA = m.a();
            if (mVarA.b() != 1 || editorInfo == null) {
                return;
            }
            if (editorInfo.extras == null) {
                editorInfo.extras = new Bundle();
            }
            androidx.emoji2.text.g gVar = mVarA.f868e;
            gVar.getClass();
            Bundle bundle = editorInfo.extras;
            l1.b bVar = (l1.b) ((b6.f) gVar.f854b).f1800w;
            int iA = bVar.a(4);
            bundle.putInt("android.support.text.emoji.emojiCompat_metadataVersion", iA != 0 ? ((ByteBuffer) bVar.f7627y).getInt(iA + bVar.f7624v) : 0);
            editorInfo.extras.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", false);
        }
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingText(int i, int i10) {
        Editable editableText = this.f8021a.getEditableText();
        this.f8022b.getClass();
        return z.r(this, editableText, i, i10, false) || super.deleteSurroundingText(i, i10);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingTextInCodePoints(int i, int i10) {
        Editable editableText = this.f8021a.getEditableText();
        this.f8022b.getClass();
        return z.r(this, editableText, i, i10, true) || super.deleteSurroundingTextInCodePoints(i, i10);
    }
}
