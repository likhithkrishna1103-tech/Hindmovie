package g1;

import android.os.Bundle;
import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
import androidx.emoji2.text.m;
import java.nio.ByteBuffer;
import ub.o;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b extends InputConnectionWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EditText f4828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t7.j f4829b;

    public b(EditText editText, InputConnection inputConnection, EditorInfo editorInfo) {
        t7.j jVar = new t7.j(11);
        super(inputConnection, false);
        this.f4828a = editText;
        this.f4829b = jVar;
        if (m.f1181k != null) {
            m mVarA = m.a();
            if (mVarA.b() != 1 || editorInfo == null) {
                return;
            }
            if (editorInfo.extras == null) {
                editorInfo.extras = new Bundle();
            }
            androidx.emoji2.text.g gVar = mVarA.f1186e;
            gVar.getClass();
            Bundle bundle = editorInfo.extras;
            f1.b bVar = (f1.b) ((o) gVar.f1172b).f12868v;
            int iA = bVar.a(4);
            bundle.putInt("android.support.text.emoji.emojiCompat_metadataVersion", iA != 0 ? ((ByteBuffer) bVar.f4694x).getInt(iA + bVar.f4691u) : 0);
            editorInfo.extras.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", false);
        }
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingText(int i, int i10) {
        Editable editableText = this.f4828a.getEditableText();
        this.f4829b.getClass();
        return t7.j.r(this, editableText, i, i10, false) || super.deleteSurroundingText(i, i10);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingTextInCodePoints(int i, int i10) {
        Editable editableText = this.f4828a.getEditableText();
        this.f4829b.getClass();
        return t7.j.r(this, editableText, i, i10, true) || super.deleteSurroundingTextInCodePoints(i, i10);
    }
}
