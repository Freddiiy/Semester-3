import { PrismaClient } from '@prisma/client'
const prisma = new PrismaClient()

export async function getText() {
    try {
        const text = await prisma.test.findUnique({
            where: {
                id: 1,
            },
        });

        return text?.test;
    } catch (error) {
        console.error(error);
    }
}

export async function insertText() {
    try {
        prisma.test.create({
            data: {
                id: 1,
                test: "text from db" 
            }
        });
    } catch(error) {
        console.error(error);
    }
}