package com.example.mohit;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public class GLTriangle {

	private float vertices[] = { 0f, 1f, // point0
			1f, -1f,// point1
			-1f, -1f // point2
	};
	private FloatBuffer vertbuff;
	
	private short[] pindex={1,2,3};
	private ShortBuffer pbuff;
	
	public GLTriangle(){
		ByteBuffer bbuff=ByteBuffer.allocateDirect(vertices.length*4);
		bbuff.order(ByteOrder.nativeOrder());
		vertbuff=bbuff.asFloatBuffer();
		vertbuff.put(vertices);
		vertbuff.position(0);
		
		ByteBuffer pbbuff=ByteBuffer.allocateDirect(pindex.length*2);
		pbbuff.order(ByteOrder.nativeOrder());
		pbuff=pbbuff.asShortBuffer();
		pbuff.put(pindex);
		pbuff.position(0);
	}
	
	public void draw(GL10 gl){
		gl.glFrontFace(GL10.GL_CW);
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glVertexPointer(2,GL10.GL_FLOAT,0,vertbuff);
		gl.glDrawElements(GL10.GL_TRIANGLES,pindex.length,GL10.GL_UNSIGNED_SHORT,pbuff);
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

	}
}
